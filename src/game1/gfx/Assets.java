package game1.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	
	// Player Blue Ninja
	public static BufferedImage[] c2_a1 = new BufferedImage[5];
	public static BufferedImage[] c2_a2 = new BufferedImage[5];
	public static BufferedImage[] c2_a3 = new BufferedImage[5];
	public static BufferedImage[] c2_throw = new BufferedImage[3];
	public static BufferedImage[] c2_stand = new BufferedImage[5];
	public static BufferedImage[] c2_sit = new BufferedImage[2];
	public static BufferedImage[] c2_run = new BufferedImage[6];
	public static BufferedImage[] c2_spin = new BufferedImage[9];
	public static BufferedImage[] c2_jump = new BufferedImage[6];
	public static BufferedImage[] c2_hurt = new BufferedImage[4];
	public static BufferedImage[] c2_defeat = new BufferedImage[5];
	//////
	
	// Player Black Ninja
	public static BufferedImage[] c3_a1 = new BufferedImage[5];
	public static BufferedImage[] c3_a2 = new BufferedImage[8];
	public static BufferedImage[] c3_a3 = new BufferedImage[5];
	public static BufferedImage[] c3_throw = new BufferedImage[3];
	public static BufferedImage[] c3_stand = new BufferedImage[5];
	public static BufferedImage[] c3_sit = new BufferedImage[2];
	public static BufferedImage[] c3_run = new BufferedImage[6];
	public static BufferedImage[] c3_spin = new BufferedImage[9];
	public static BufferedImage[] c3_jump = new BufferedImage[6];
	public static BufferedImage[] c3_hurt = new BufferedImage[4];
	public static BufferedImage[] c3_defeat = new BufferedImage[5];
	//////
	
	static int height = 1024/4;
	static int width = 1024/6;
	public static BufferedImage bg;
	public static BufferedImage go;
	public static BufferedImage hc,hc2;
	
	public static void init()
	{	 
		//background
		bg = ImageLoader.loadImage("res/textures/area31.jpg");
		go = ImageLoader.loadImage("res/textures/got2.png");
		hc = ImageLoader.loadImage("res/textures/health.png");
		hc2 = ImageLoader.loadImage("res/textures/health2.png");
		
		// Player c2
		SpriteSheet S2 = new SpriteSheet(ImageLoader.loadImage("res/textures/BlueNinja2.png"));
		c2_a1[0] = S2.crop(0,0,100,150);
		c2_a1[1] = S2.crop(210,0,150,150);
		c2_a1[2] = S2.crop(370,0,160,150);
		c2_a1[3] = S2.crop(570,0,140,150);
		c2_a1[4] = S2.crop(740,0,130,150);
		c2_a1[0] = S2.crop(0,300,100,150);
		c2_a2[1] = S2.crop(100,300,95,150);
		c2_a2[2] = S2.crop(200,300,260,150);
		c2_a2[3] = S2.crop(480,300,230,150);
		c2_a2[4] = S2.crop(720,300,160,150);
		c2_a3[0] = S2.crop(0,450,100,170);
		c2_a3[1] = S2.crop(100,450,160,170);
		c2_a3[2] = S2.crop(260,450,150,170);
		c2_a3[3] = S2.crop(412,450,120,170);
		c2_a3[4] = S2.crop(530,450,120,170);
		c2_throw[0] = S2.crop(650,450,100,150);
		c2_throw[1] = S2.crop(750,450,115,150);
		c2_throw[2] = S2.crop(860,450,115,150);
		
		S2 = new SpriteSheet(ImageLoader.loadImage("res/textures/BlueNinja1.png"));
		c2_stand[0] = S2.crop(20,0,75,120);
		c2_stand[1] = S2.crop(95,0,75,120);
		c2_stand[2] = S2.crop(170,0,75,120);
		c2_stand[3] = S2.crop(245,0,75,120);
		c2_stand[4] = S2.crop(330,0,75,120);
		c2_sit[0] = S2.crop(405,0,81,120);
		c2_sit[1] = S2.crop(485,0,81,120);
		for(int i=0;i<6;i++)
		c2_run[i] = S2.crop(20+110*i,120,110,120);
		c2_spin[0] = S2.crop(30,250,80,170);
		c2_spin[1] = S2.crop(110,250,80,170);
		c2_spin[2] = S2.crop(200,250,85,170);
		c2_spin[3] = S2.crop(285,250,100,170);
		c2_spin[4] = S2.crop(385,250,80,170);
		c2_spin[5] = S2.crop(465,250,100,170);
		c2_spin[6] = S2.crop(568,250,90,170);
		c2_spin[7] = S2.crop(660,250,88,170);
		c2_spin[8] = S2.crop(751,250,90,170); 
		c2_jump[0] = S2.crop(30,250,80,170);
		c2_jump[1] = S2.crop(110,250,80,170);
		c2_jump[2] = S2.crop(200,250,85,170);
		c2_jump[3] = S2.crop(568,250,90,170);
		c2_jump[4] = S2.crop(660,250,88,170);
		c2_jump[5] = S2.crop(751,250,90,170);
		c2_hurt[0] = S2.crop(0,410,75,120);		
		c2_hurt[1] = S2.crop(75,410,90,120);	
		c2_hurt[2] = S2.crop(170,410,90,120);
		c2_hurt[3] = S2.crop(270,410,90,120);
		c2_defeat[0] = S2.crop(440,410,90,120);
		c2_defeat[1] = S2.crop(540,410,90,120);
		c2_defeat[2] = S2.crop(630,410,105,120);
		c2_defeat[3] = S2.crop(740,410,110,120);
		c2_defeat[4] = S2.crop(850,410,130,120);		
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	
		SpriteSheet S3 = new SpriteSheet(ImageLoader.loadImage("res/textures/BlackNinja12.png"));
		c3_stand[4] = S3.crop(575,0,62,120);
		c3_stand[3] = S3.crop(660,0,62,120);
		c3_stand[2] = S3.crop(725,0,62,120);
		c3_stand[1] = S3.crop(790,0,62,120);
		c3_stand[0] = S3.crop(859,0,62,120);
		c3_sit[1] = S3.crop(426,0,75,120);
		c3_sit[0] = S3.crop(500,0,75,120);
		for(int i=0;i<6;i++)
			c3_run[5-i] = S3.crop(280+108*i,120,110,120);
		c3_spin[8] = S3.crop(110,250,79,170);
		c3_spin[7] = S3.crop(185,250,85,118);
		c3_spin[6] = S3.crop(275,250,85,170);
		c3_spin[5] = S3.crop(375,250,100,170);
		c3_spin[4] = S3.crop(475,250,80,170);
		c3_spin[3] = S3.crop(555,250,100,170);
		c3_spin[2] = S3.crop(658,250,90,170);
		c3_spin[1] = S3.crop(759,250,88,170);
		c3_spin[0] = S3.crop(851,250,90,170);
		c3_hurt[3] = S3.crop(595,430,90,120);		
		c3_hurt[2] = S3.crop(685,430,90,120);	
		c3_hurt[1] = S3.crop(775,430,90,120);
		c3_hurt[0] = S3.crop(870,430,75,120);
		c3_defeat[4] = S3.crop(0,430,110,120);
		c3_defeat[3] = S3.crop(115,430,110,120);
		c3_defeat[2] = S3.crop(230,430,90,120);
		c3_defeat[1] = S3.crop(320,430,90,120);
		c3_defeat[0] = S3.crop(420,430,90,120);
		
		S3 = new SpriteSheet(ImageLoader.loadImage("res/textures/BlackNinja22.png"));
		c3_a1[4] = S3.crop(340,0,120,120);
		c3_a1[3] = S3.crop(490,0,125,120);
		c3_a1[2] = S3.crop(631,0,130,120);
		c3_a1[1] = S3.crop(760,0,90,120);
		c3_a1[0] = S3.crop(859,0,90,120);
		c3_a2[7] = S3.crop(0,240,140,160); 
		c3_a2[6] = S3.crop(160,240,160,160); 
		c3_a2[5] = S3.crop(330,240,90,160);  
		c3_a2[4] = S3.crop(430,240,75,160);
		c3_a2[3] = S3.crop(508,240,90,160);
		c3_a2[2] = S3.crop(608,240,120,160);
		c3_a2[1] = S3.crop(730,240,140,160);
		c3_a2[0] = S3.crop(870,240,100,160);
		c3_throw[2] = S3.crop(32,400,100,160);
		c3_throw[1] = S3.crop(140,400,100,160);
		c3_throw[0] = S3.crop(240,400,100,160);
		c3_a3[4] = S3.crop(490,0,125,146);
		c3_a3[3] = S3.crop(360,400,120,153);
		c3_a3[2] = S3.crop(480,400,160,153);
		c3_a3[1] = S3.crop(640,400,140,153);
		c3_a3[0] = S3.crop(790,400,160,153);
		
	}

}
