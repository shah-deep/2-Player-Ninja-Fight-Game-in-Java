package game1.display;


import game1.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


public class count_down {

	JLabel temp = new JLabel("");
	public static JLabel jltime;
	
	NumberFormat format;

    public static Timer timer;
    private long initial;
    private long ttime2;
    public String ttime;
    private long remaining;
    private game gm;

    
    public count_down() {
    
        ttime = "1";

    }
    
    public JLabel timer() {
    	jltime = new JLabel(" ");
         jltime.setForeground(Color.BLACK);
         jltime.setIcon(new ImageIcon("res/textures/cd_bg.png"));
         jltime.setIconTextGap(-180);
         jltime.setBounds(860,5,180,55);
         jltime.setOpaque(true);
         jltime.repaint();
         jltime.setFont(new Font("Arial Black",Font.PLAIN ,60));
  
         updateDisplay();
    	return jltime;
    } 
    
    
    void updateDisplay() {

        Timeclass tc = new Timeclass();
        timer = new Timer(1000, tc);
        initial = System.currentTimeMillis();
        timer.start();
    }


    public class Timeclass implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            remaining = convertTime();
            long current = System.currentTimeMillis();
            long elapsed = current - initial;
            remaining -= elapsed;

            format = NumberFormat.getNumberInstance();
            format.setMinimumIntegerDigits(2);

            if (remaining < 0)
                remaining = (long) 0;
            int minutes = (int) (remaining / 60000);
            int seconds = (int) ((remaining % 60000) / 1000);
            jltime.setText(format.format(minutes) + ":"
                    + format.format(seconds));

            if (remaining == 0) {
                jltime.setText("");
                timer.stop();
                game.gameOver=true;
                try {
                    gm.quit(gm.g);
                    }
                    catch(NullPointerException e1) {
                    }
            }
        }
    }

 
    public long convertTime() {

        ttime2 = Long.parseLong(ttime);
        long converted = (ttime2 * 60000) + 1000;
        return converted;
    }
}
