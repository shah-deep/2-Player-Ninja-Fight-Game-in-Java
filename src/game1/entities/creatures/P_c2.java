package game1.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import game1.gfx.Assets;
import game1.states.State;
import game1.front;
import game1.game;
import game1.restore_defaults;
import game1.display.count_down;
import game1.display.display;


public class P_c2 extends Creature
{
	private game gm;
	public String flagship="stand";
	static int count=0;
	public static BufferedImage[] c2;
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	private static int temp = 0;
	public static boolean dead = false;

	
	public P_c2(game g,float x, float y) {
		super(x, y,Creature.DC_width,Creature.DC_height);
		this.gm=g;	
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = getWidth();
		bounds.height = getHeight();
		
	}


	@Override
	public void tick() 
	{
		if(!game.gameOver) {
		getInput();
		move();
		}
		
	}
	public void getInput()
	{
		xMove = 0;
		yMove = 0;
		if(y<=600 && count ==0)
		{
		
				yMove = 8;
				xMove = 1;
		}
		if(game.getKeyManager().up2&&y>600)
			{
			yMove = -speed;
			flagship = "running";
			}
		if(game.getKeyManager().down2&&y<750)
			{
			yMove = speed;
			flagship = "running";
			}
		if(game.getKeyManager().right2&&x<1650)
			{
			xMove = speed;
			flagship = "running";
			}
		if(game.getKeyManager().left2&&x>20)
			{
			xMove = -speed;
			flagship = "running";
			}
		if(game.getKeyManager().atk2_1)
			{
			flagship = "p2a1";
			if(checkEntityCollisions() && checkTimerNext())
			State.getState().getP3().hurt(1);
			
			}
		if(game.getKeyManager().atk2_2&&x<1650)
		{
			flagship = "p2a2";
			xMove = speed;
			if(checkEntityCollisions() && checkTimerNext())
			State.getState().getP3().hurt(1);
		}
		if(game.getKeyManager().atk2_3&&x<1650)
		{
			flagship = "p2a3";
			xMove = 2*speed;
			if(checkEntityCollisions() && checkTimerNext())
			State.getState().getP3().hurt(1);
		}
		if(game.getKeyManager().jump2&&y>=600&&x<1350)
		{
			flagship = "jump";
			count = 1;
		}
		if(flagship == "jump" && count ==1 )
		{
			yMove = -8;
			xMove = 1;
					if(y<350)
						count=0;
		}
		if(game.getKeyManager().exit)
		{
			game.sound.stop();
			display.getFrame().dispose();
			gm.running = false;
			new restore_defaults(gm);
			new front();
			
		}
	}

	public void render(Graphics g) 
	{
		int c_c2 = 0;
		int c_c21 = game.count_c21;		
		
		if(flagship == "stand"&&dead==false)
		{
			c2 = Assets.c2_stand; 
			setWH(170,DC_height);
			game.arrSize = c2.length-1;
			game.checkCount();
			c_c2 = game.count_c2;
			g.drawImage(c2[c_c2], (int) x, (int) y,this.width,this.height, null);
		}
		else if(flagship == "running"&&dead==false)
		{
			c2 = Assets.c2_run; 
			setWH(300,DC_height); 
			game.arrSize = c2.length-1;
			game.checkCount();
			c_c2 = game.count_c2;
			g.drawImage(c2[c_c2], (int) x, (int) y,this.width,this.height, null);
			flagship = "stand";
			if(y<600)
				y=600;
		}
		
		else if(flagship == "p2a1"&&dead==false)
		{
			c2 = Assets.c2_a1; 
			setWH(300,DC_height); 
			game.arrSize = c2.length-1;
			game.checkCount();
			c_c2 = game.count_c2;
			g.drawImage(c2[c_c2], (int) x, (int) y,this.width,this.height, null);
			flagship = "stand";
			if(y<600)
				y=600;
		}
		else if(flagship == "p2a2"&&dead==false)
		{
			
			c2 = Assets.c2_a2;  
			setWH(300,DC_height+50);
			game.arrSize = c2.length-1;
			game.checkCount();
			c_c2 = game.count_c2;
			g.drawImage(c2[c_c2], (int) x, (int) y,this.width,this.height, null);
			flagship = "stand";
			if(y<600)
				y=600;
		}
		else if(flagship == "p2a3"&&dead==false)
		{
			c2 = Assets.c2_a3;  
			setWH(300,DC_height);
			game.arrSize = c2.length-1;
			game.checkCount();
			c_c2 = game.count_c2;
			g.drawImage(c2[c_c2], (int) x, (int) y,this.width,this.height, null);
			flagship = "stand";
			if(y<600)
				y=600;
		}
		
		else if(flagship == "hurt"&&dead==false)
		{
				if(temp==0)
				{
					game.count_c2=0;
					temp=1;
				}
				c2 = Assets.c2_hurt;  
				setWH(200,DC_height);
				game.arrSize = c2.length-1;
				game.checkCount();
				c_c2 = game.count_c2;
				g.drawImage(c2[c_c2], (int) x, (int) y,this.width,this.height, null);
				if(c_c2==game.arrSize)
				{
					flagship="stand";
					temp=0;
				}	
				if(y<600)
					y=600;
			
			
		}
		
		else if(flagship == "jump"&&dead==false)
		{
			g.drawImage(Assets.c2_spin[c_c21], (int) x, (int) y,250,DC_height, null);
			if(y>600&&count==0)
			{
				flagship="stand";
			}
			
		}
		else if(flagship == "death"&&dead==false)
		{
			c2 = Assets.c2_defeat;  
			setWH(300,DC_height);
			game.arrSize = c2.length-1;
			game.checkCount();
			c_c2 = game.count_c2;
			g.drawImage(c2[c_c2], (int) x, (int) y,this.width,this.height, null);
			if(c_c2==game.arrSize)
			{
				flagship="dead";
				dead = true;
			}
			if(y<600)
				y=600;
		}
		else if (flagship=="dead")
		{
			g.drawImage(Assets.c2_defeat[4], (int) x, (int) y,250,DC_height, null);
			count_down.jltime.setText("");
			count_down.timer.stop();
		}
					
	}
	
	
	@Override
	public void hurt(int amt){
		super.hurt(amt);
		if(health>0)
		flagship="hurt";
		if(health <= 0){
			flagship="death"; 
			game.gameOver = true;
		}
	}
	
	private boolean checkTimerNext() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return false;
		else {
			attackTimer = 0;
			return true;	
		}
	}
	
	private void setWH(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	}

