package game1;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import game1.restore_defaults;
import game1.display.display;
import game1.gfx.Assets;
import game1.input.KeyManager;
import game1.sounds.sounds;
import game1.states.GameState;
import game1.states.State;

public class game implements Runnable
{

	private display display;
	public static int width;
	public static int height;
	public String title;
	public static boolean gameOver = false;
	
	public boolean running = false;
	private Thread thread;	
	private BufferStrategy bs;
	public Graphics g;
	private State gameState;
	private static KeyManager keyManager;
	public static sounds sound;
	
	public game() {
		
	}
	
	public game(String title,int width,int height) 
	{
		this.width= width;
		this.height= height;
		this.title = title;
		keyManager = new KeyManager();
		sound = new sounds("res/sounds/sound1.wav");
	}
	private void init()
	{
		display = new display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		State.setState(gameState);
	}
	
	public static int x = 0;
	public static int count_c2 = 0, arrSize = 0;
	public static int count_c3 = 0, arrSize2 = 0;
	public static int count_c21 = 0, count_c31 = 0;

	
	public void run() 
	{
		init();
		int fps = 60;
		double timePerTick = 1000000000/ fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int c_count = 0;
		
		
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer +=now-lastTime;
			lastTime = now;
			
			if(delta>1)
			{
			tick();
			render();
			delta--;
			c_count++;
		
			
				if(c_count==9)
					{
						
						count_c2++;
						count_c3++;
						count_c21++;
						count_c31++;
						c_count=0;
					}
			}
			if(timer>=1000000000)
			{
				timer = 0;
			}
		}
		stop();
	}
	
	public static KeyManager getKeyManager() {
		return keyManager;
	}
	
	public static void checkCount() {
		if(count_c2>game.arrSize)
		  {
			  count_c2 = 0;
		  }
	}
	
	public static void checkCount2() {
		if(count_c3>game.arrSize2)
		  {
			  count_c3 = 0;
		  }
	}
	
	private void render() 
	{
		  bs = display.getCanvas().getBufferStrategy();
		  if(bs==null)
		  {
			   display.getCanvas().createBufferStrategy(3);
			   return;
		  }
		  g=bs.getDrawGraphics();
		  g.clearRect(0, 0, width, height);
		  //Start drawing
		  
		 if(State.getState() != null)
			State.getState().render(g);

		  //End drawing
		  bs.show();
		  g.dispose();
		  
		  
		  if(count_c21==6)
		  {
			  count_c21 = 2;
		  }
		  if(count_c31==6)
		  {
			  count_c31 = 2;
		  }
		  
	}
	
	
	private void tick() 
	{
		keyManager.tick();
		if(State.getState() != null)
			State.getState().tick();
		
	}
	public synchronized void start()
	{	if(running)
		stop();
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{	
		if(!running)
			return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	public void quit(Graphics g) 
	{	
		g.drawImage(Assets.go, 620, 0, null);
	
		if(game.getKeyManager().exit)
		{
			sound.stop();
			display.getFrame().dispose();
			running = false;
			new restore_defaults(this);
			new front();
		}
	}
	
}
