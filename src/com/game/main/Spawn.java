package com.game.main;


import java.awt.Graphics;
import java.util.Random;

public class Spawn {
	private Handler handler = new Handler();
	private HUD hud;
	private Random random = new Random();
	private int Scorekeep = 0;
	private int timer = 1000;
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		
	}
	public void tick()  {
			Scorekeep += HUD.Scoregrowth;
			timer -= 2;
			if(Scorekeep>=hud.LevelgrowthperScore) {
				Scorekeep = 0;
				switch(hud.Level) {
					case 3:
						handler.Objektadd(new BasicEnemy2(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy2,handler));
						handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
						break;
					case 5:
						handler.Objektadd(new AIEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.AIEnemy,handler));
						handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
						break;
					case 7:
						handler.Objektadd(new BasicEnemy2(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy2,handler));
					    handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
						break;
					case 8:
						handler.Objektadd(new AIEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.AIEnemy,handler));
						break;
					case 10:
						handler.Objektadd(new BasicEnemy2(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy2,handler));
						handler.Objektadd(new BasicEnemy2(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy2,handler));
						break;
					case 12:
						handler.Objektadd(new AIEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.AIEnemy,handler));
						break;
					case 14:
						handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
						handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
						break;
					case 15:
						handler.allesloschen2();
						hud.LevelgrowthperScore=1000000000;
						if(timer<=0) handler.Objektadd(new Boss1((Main.breite2/2)-35,0,ID.Boss1,handler));
						break;
				}
			}
			if(HUD.LP<=0) {
				handler.allesloschen();
				HUD.LP = 0;
			}
			if(HUD.LP2<=0) {
				handler.allesloschen();
				HUD.LP2 = 0;
				Menu.Gameover = 0;
			}
	}
	public void render(Graphics g) {
		
	}
}
