package game1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class front implements ActionListener
{

    JLabel lab,sac;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JFrame frame;
    
     public front()
    {
        frame = new JFrame("AKD presents");
        frame.setBounds(0,0,1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        
        Container c =frame.getContentPane();
        c.setBackground(Color.DARK_GRAY);
        c.setLayout(null);

        ImageIcon start = new ImageIcon("res\\textures\\start.png");
        ImageIcon quit = new ImageIcon("res\\textures\\quit.png");
        ImageIcon front = new ImageIcon("res\\textures\\front2.jpg");
       // ImageIcon sound = new ImageIcon("res\\textures\\settings.jpg");
        
        
        btn1 = new JButton(start);
        btn1.setBounds(8, 10,start.getIconWidth(),start.getIconHeight());
        
        
        btn2 = new JButton(quit);
        btn2.setBounds(8, 190,quit.getIconWidth(),quit.getIconHeight());

       // btn3 = new JButton(sound);
        //btn3.setBounds(0, 372,sound.getIconWidth(),sound.getIconHeight());
        
       
        JLabel pic = new JLabel(front);
        pic.setBounds(200, 0, front.getIconWidth()+10, front.getIconHeight()+20);

        
        JLabel sac = new JLabel("");
        
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
      //  btn3.addActionListener(this);
       

        c.add(btn1);
        c.add(btn2);
        //c.add(btn3);
       
        c.add(pic);
        c.add(sac);

        lab = new JLabel("");
        lab.setBounds(300, 50, 200, 40);
        c.add(lab);

        sac = new JLabel("");
        sac.setBounds(300, 50, 200, 40);
        c.add(sac);

        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ac) 
    {
        if(ac.getSource()==btn1)
        {
        	new game("SHILP V/S UJJWAL",1920,1080).start();
        	
        
        frame.dispose();
        }
        else if(ac.getSource()==btn2)
        {
        	frame.dispose();
        }
        else
        {
        
        }
    }

}