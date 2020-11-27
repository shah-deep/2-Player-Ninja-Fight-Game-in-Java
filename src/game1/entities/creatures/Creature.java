package game1.entities.creatures;

import game1.entities.Entity;
import game1.states.State;



public abstract class Creature extends Entity {
	
	
	protected float speed;
	protected float xMove,yMove;
	
	public static final float Default_speed  = 3.0f;
	public static final int DC_height = 260,DC_width = 250;

	public Creature(float x, float y , int width, int height) {
		super(x, y,width,height);
		
		speed = Default_speed;	
		
	}
	
	public void move()
	{
		if((State.getState().getP2().getX()+State.getState().getP2().getWidth()-25) < State.getState().getP3().getX()+50)
			x += xMove;
		else {
			if(this == State.getState().getP2())
				x = State.getState().getP2().getX()-1;
			else if(this == State.getState().getP3())
				x = State.getState().getP3().getX()+1;
		}
		
		y += yMove;
	}
	

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}


	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}
