package game1.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import game1.gfx.Assets;
import game1.states.State;
import game1.game;
import game1.display.count_down;


public class P_c3 extends Creature
{
	//private game gm;
	public String flagship="stand";
	static int count=0;
	public static BufferedImage[] c3;
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	private static int temp = 0;
	public static boolean dead = false;
	
	
	public P_c3(game g,float x, float y) {
		super(x, y,Creature.DC_width,Creature.DC_height);
		//this.gm=g;
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
		
				yMove = 6;
				xMove = -1;
		}
		if(game.getKeyManager().up3&&y>600)
			{
			yMove = -speed;
			flagship = "running";
			}
		if(game.getKeyManager().down3&&y<750)
			{
			yMove = speed;
			flagship = "running";
			}
		if(game.getKeyManager().right3&&x<1650)
			{
			xMove = speed;
			flagship = "running";
			}
		if(game.getKeyManager().left3&&x>20)
			{
			xMove = -speed;
			flagship = "running";
			}
		if(game.getKeyManager().atk3_1)
			{
			flagship = "p2a1";
			if(checkEntityCollisions() && checkTimerNext())
			State.getState().getP2().hurt(1);
			}
		if(game.getKeyManager().atk3_2&&x<1650)
		{
			flagship = "p2a2";
			if(checkEntityCollisions() && checkTimerNext())
			State.getState().getP2().hurt(1);
			xMove = -speed;
		}
		if(game.getKeyManager().atk3_3&&x<1650)
		{
			flagship = "p2a3";
			if(checkEntityCollisions() && checkTimerNext())
			State.getState().getP2().hurt(1);
			xMove = -2*speed;
		}
		if(game.getKeyManager().jump3&&y>=600&&x<1450)
		{
			flagship = "jump";
			count = 1;
		}
		if(flagship == "jump" && count ==1 )
		{
			yMove = -6;
			xMove = -1;
					if(y<350)
						count=0;
		}
	}

	public void render(Graphics g) 
	{
		int c_c3 = 0;
		int c_c31 = game.count_c31;
		
		if(flagship == "stand"&&dead==false)
		{
			c3 = Assets.c3_stand;
			setWH(120,DC_height);
			game.arrSize2 = c3.length-1;
			game.checkCount2();
			c_c3 = game.count_c3;
			g.drawImage(c3[c_c3], (int) x, (int) y,this.width,this.height, null);
		}
		else if(flagship == "running"&&dead==false)
		{
			c3 = Assets.c3_run; 
			setWH(250,DC_height);
			game.arrSize2 = c3.length-1;
			game.checkCount2();
			c_c3 = game.count_c3;
			g.drawImage(c3[c_c3], (int) x, (int) y,this.width,this.height, null);
			flagship = "stand";
			if(y<600)
				y=600;
		}
		
		else if(flagship == "p2a1"&&dead==false)
		{
			c3 = Assets.c3_a1; 
			setWH(250,DC_height);
			game.arrSize2 = c3.length-1;
			game.checkCount2();
			c_c3 = game.count_c3;
			g.drawImage(c3[c_c3], (int) x-40, (int) y,this.width,this.height, null);
			flagship = "stand";
			if(y<600)
				y=600;
		}
		else if(flagship == "p2a2"&&dead==false)
		{
			
			c3 = Assets.c3_a2; 
			setWH(250,DC_height+100);
			game.arrSize2 = c3.length-1;
			game.checkCount2();
			c_c3 = game.count_c3;
			g.drawImage(c3[c_c3], (int) x, (int) y-70,this.width,this.height, null);
			flagship = "stand";
			if(y<600)
				y=600;
		}
		else if(flagship == "p2a3"&&dead==false)
		{
			c3 = Assets.c3_a3;
			setWH(250,DC_height+100);
			game.arrSize2 = c3.length-1;
			game.checkCount2();
			c_c3 = game.count_c3;
			g.drawImage(c3[c_c3], (int) x, (int) y-100,this.width,this.height, null);
			flagship = "stand";
			if(y<600)
				y=600;
		}
		else if(flagship == "hurt"&&dead==false)
		{
				if(temp==0)
				{
					game.count_c3=0;
					temp=1;
				}
				c3 = Assets.c3_hurt;  
				setWH(200,DC_height);
				game.arrSize2 = c3.length-1;
				game.checkCount2();
				c_c3 = game.count_c3;
				g.drawImage(c3[c_c3], (int) x, (int) y,this.width,this.height, null);
				if(c_c3==game.arrSize2)
				{
					flagship="stand";
					temp=0;
				}	
				if(y<600)
					y=600;
			
			
		}
				
		else if(flagship == "jump"&&dead==false)
		{
			g.drawImage(Assets.c3_spin[c_c31], (int) x, (int) y,250,DC_height, null);
			if(y>600&&count==0)
			{
				flagship="stand";
			}
			
		}
		
		else if(flagship == "death"&&dead==false)
		{
			c3 = Assets.c3_defeat;  
			setWH(300,DC_height);
			game.arrSize2 = c3.length-1;
			game.checkCount2();
			c_c3 = game.count_c3;
			g.drawImage(c3[c_c3], (int) x, (int) y,this.width,this.height, null);
			if(c_c3==game.arrSize2)
			{
				flagship="dead";
				dead = true;
			}
			if(y<600)
				y=600;
		}
		
		else if (flagship=="dead")
		{
			g.drawImage(Assets.c3_defeat[4], (int) x, (int) y,250,DC_height, null);
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
		//	count_down.remaining = 0;
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

