package game1;

import game1.game;
import game1.entities.Entity;
import game1.entities.creatures.P_c2;
import game1.entities.creatures.P_c3;

public class restore_defaults {
	
	public static void restore_P2(game g, float x, float y) {
		P_c2 p2 = new P_c2(g,x,y);
		p2.setHealth(Entity.Default_health);
		P_c2.dead = false;
	}
	
	public static void restore_P3(game g, float x, float y) {
		P_c3 p3 = new P_c3(g,x,y);
		p3.setHealth(Entity.Default_health);
		P_c3.dead = false;
	}
	
	public restore_defaults(game g){
		restore_P2(g,280,600);
		restore_P3(g,1400,620);
		game.gameOver = false;
	}
}
