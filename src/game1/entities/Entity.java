package game1.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import game1.states.State;

public abstract class Entity {

	protected float x, y;
	protected int width, height;
	protected int health;
	protected Rectangle bounds;
	public static final int Default_health=28;
	
	public Entity(float x, float y,int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height= height;
		health = Default_health;
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public boolean checkEntityCollisions(){
		if(State.getState().getP3().getCollisionBounds(0f, 50f).intersects(State.getState().getP2().getCollisionBounds(0f, 50f)))
			return true;
		else
			return false;
	} 
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);

	public void hurt(int amt) {
		this.health -= amt;
		
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
}
