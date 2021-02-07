package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;



public class HUD {

	private Handler handler = new Handler();

	
	public static double LP = 100;
	public static int LP2 = 1000;
	public static double LPMAX = 100;
	private int TextGrosse = 24;
	public int Score = 0;
	public int Level = 1;
	public static int Scoregrowth = 2;
	public int LevelgrowthperScore = 1000;
	
	
	
	public void tick()  {
		if(LP>0) {
			Score += Scoregrowth;
			Menu.Coins += Scoregrowth;
			if(Score % LevelgrowthperScore == 0) Level++;
		}
	}
	public void render(Graphics g) {

		if(LP<=0 || LP2<=0) {
			
			if(Menu.Gameover != 1) {
				
				handler.allesloschen();
				LPMAX = 100;
				if(LP2<=0) {
					g.setColor(Color.white);
					g.setFont(new Font("Monospaced",Font.PLAIN,150));
					g.drawString("YOU DID IT", 150, 200);
					g.setFont(new Font("Monospaced",Font.PLAIN,40));
					g.drawString("Thank you for playing my game", 300, 300);
					
				}else {
					g.setColor(Color.white);
					g.setFont(new Font("Monospaced",Font.PLAIN,150));
					g.drawString("GAME OVER", 200, 200);
					g.setFont(new Font("Monospaced",Font.PLAIN,50));
					g.drawString("Score :"+Score, 475, 270);
					g.drawString("Level :"+Level, 475, 330);
				}
				g.setFont(new Font("Monospaced",Font.PLAIN,60));
				g.drawString("Retry",530,450);
				g.drawString("Quit", 550, 550);
				g.drawRect(475, 400, 300, 75);
				g.drawRect(475, 500, 300, 75);
			}
		}
		else {
			g.setColor(Color.darkGray);
			g.fillRect(15,20,(int)LPMAX*2,40);
			g.setColor(new Color(150,255-(200-(int)LP),0));
			g.fillRect(15,20,(int)LP*2,40);
			g.setColor(Color.white);
			g.drawRect(15,20,(int) LPMAX*2,40);
			g.setFont(new Font("Monospaced",Font.PLAIN,TextGrosse));
			g.drawString(LP+" Lebenspunkte", 15, 15);
			g.drawString("Score:  "+Score, 15,85);
			g.drawString("Level:  "+Level, 15,110);
			g.drawString("Space to open Shop", 15,160);
			if(Level==15) {
				g.setColor(Color.white);
				g.drawRect(Main.breite2/2,20,1000/2,30);
				g.setColor(Color.darkGray);
				g.fillRect(Main.breite2/2,20,1000/2,30);
				g.setColor(Color.RED);
				g.fillRect(Main.breite2/2,20,LP2/2,30);
				g.drawString("Drück R um zu schießen", 15, 185);	
			}
		    g.setColor(Color.YELLOW);
			g.drawString("Coins:  "+Menu.Coins, 15,135);
			g.setColor(Color.white);
			g.drawRect(Main.breite2-75, 0, 58, 60);
			g.fillRect(Main.breite2-40, 10, 10, 40);
			g.fillRect(Main.breite2-60, 10, 10, 40);
		
	}
		if(Menu.Gameover == 1) {
			Score = 0;
			Level = 1;
			LevelgrowthperScore = 500;
			Menu.Coins = 0;
			Menu.Gameover = 0;

		}

	}


}
