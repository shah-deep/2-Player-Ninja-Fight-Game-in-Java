package game1.states;

import java.awt.Graphics;
import game1.game;
import game1.entities.Entity;


public abstract class State {

	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}

	
	protected game game;
	
	public State(game game)
	{
		this.game=game;
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public Entity getP2() {
		return null;
	}

	public Entity getP3() {
		return null;
	}
	
}
