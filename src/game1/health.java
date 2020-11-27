package game1;

import java.awt.Color;
import java.awt.Graphics;
import game1.gfx.Assets;
import game1.states.State;


	
	public class health
	{
		public void tick()
		{
			
		}
		
		public void render(Graphics g)
		{
			 g.drawImage(Assets.hc,50,100,250,100, null);
			 g.drawImage(Assets.hc2,1600,100,250,100, null);
			 g.setColor(Color.GREEN);
			 g.fillRect(73, 117, (int) ((State.getState().getP2().getHealth())*7.3) , 19);
			 g.fillRect(1620, 116, (int) ((State.getState().getP3().getHealth())*7.3) , 19);
		}
	}


