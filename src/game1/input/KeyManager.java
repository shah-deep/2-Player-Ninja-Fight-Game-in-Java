package game1.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up3,down3,left3,right3,up2,down2,left2,right2,atk2_1,atk2_2,atk2_3,jump2,atk3_1,atk3_2,atk3_3,jump3,exit,adstop;
	
	public KeyManager() 
	{
		keys = new boolean[256];
	}
	
	public void tick()
	{
		//player3
		up3 = keys[KeyEvent.VK_UP];
		right3 = keys[KeyEvent.VK_RIGHT];
		left3 = keys[KeyEvent.VK_LEFT];
		down3 = keys[KeyEvent.VK_DOWN];
		atk3_1 = keys[KeyEvent.VK_J];
		atk3_2 = keys[KeyEvent.VK_K];
		atk3_3 = keys[KeyEvent.VK_L];
		jump3 = keys[KeyEvent.VK_SHIFT];
		
		//player 2
		up2 = keys[KeyEvent.VK_W];
		right2 = keys[KeyEvent.VK_D];
		left2 = keys[KeyEvent.VK_A];
		down2 = keys[KeyEvent.VK_S];
		atk2_1 = keys[KeyEvent.VK_Z];
		atk2_2 = keys[KeyEvent.VK_X];
		atk2_3 = keys[KeyEvent.VK_C];
		jump2 = keys[KeyEvent.VK_SPACE];
		
		
		exit = keys[KeyEvent.VK_ESCAPE];
		adstop = keys[KeyEvent.VK_BACK_SPACE];
		
	}
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		try {
		keys[e.getKeyCode()] = true;
		} catch(Exception e1) {}
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
		
	}

}
