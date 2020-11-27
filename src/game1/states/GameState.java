package game1.states;
import game1.World;
import game1.game;
import game1.health;
import game1.entities.creatures.P_c2;
import game1.entities.creatures.P_c3;
import java.awt.Graphics;


public class GameState extends State {


private World world;
private P_c2 P_2;
private P_c3 P_3;
health hc = new health();
	
	public GameState(game game){
		super(game);
		world = new World();
		P_2 = new P_c2(game,280,600);
		P_3 = new P_c3(game,1400,620);
	}
	
	@Override
	public void tick() 
	{
		world.tick();
		P_2.tick();
		P_3.tick();	
		hc.tick();
		
	}
	

	@Override
	public void render(Graphics g) 
	{
		world.render(g);
		P_2.render(g);
		P_3.render(g);
		hc.render(g);
		if(game.gameOver)
			game.quit(g);
	}
	
	
	public P_c2 getP2() {
		return P_2;
	}
	
	public P_c3 getP3() {
		return P_3;
	}

}
