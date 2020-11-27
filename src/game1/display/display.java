package game1.display;

import java.awt.*;
import game1.display.count_down;
import javax.swing.*;

public class display {
	
	public static JFrame frame;
	private Canvas canvas;
	private String title;
	private int width,height;
	
	public display(String title, int width,int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		  
		createDisplay();
	}

	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width,height);
		
		count_down cd = new count_down();
		
      
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);

		frame.add(cd.timer());
		frame.add(cd.temp);
		frame.add(canvas);
		frame.setUndecorated(true);	
		frame.pack();			
		frame.setVisible(true);
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public static JFrame getFrame()
	{
		return frame;
	}
}
