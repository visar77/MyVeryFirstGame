package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.game.main.Main.STATE;


public class Menu extends MouseAdapter {
	
	private Color colorofPlayer;
	private Main main;
	private Handler handler = new Handler();
	private Random random = new Random();
	private HUD hud = new HUD();
	public static int Gameover = 0;
	public static int Pause = 1;
	public static int Coins;
	
	
	public Menu(Main main, Handler handler,HUD hud) {
		this.main = main;
		this.handler = handler;
		this.hud = hud;
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(main.gameState== STATE.GUI) {
			if((my>=100 && my<=164)&&(mx>=400 && mx<=800)) {
				main.gameState = STATE.GAME;
				Pause = 1;
				handler.allesloschen();
				handler.Objektadd(new Player(Main.breite2/2,Main.hohe2/2,ID.Player,handler, Color.white));
				handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
				colorofPlayer = new Color(255,255,255);
			}
			else if((my>=500 && my<=564)&&(mx>=400 && mx<=800)) {
				System.exit(1);
			}
			else if((my>=300 && my<=364)&&(mx>=400 && mx<=800)) {
				main.gameState = STATE.HELP;
			}
			else if((my>=0 && my<=50)&&(mx>=0 && mx<=330)) {
				main.gameState = STATE.COLORMENU;
			}
		}
		else if(main.gameState== STATE.HELP) {
			if((my>=50 && my<=110)&&(mx>=900 && mx<=1120)) main.gameState = STATE.GUI;
		}
		else if(main.gameState == STATE.COLORMENU) {
			Pause = 1;
			for(int i=0; i<20;i++) {
				handler.Objektadd(new MenuParticle(random.nextInt((Main.breite2-100)+1)-40,random.nextInt((Main.hohe2-100)+1)-40,ID.MenuParticle,handler));
			}
			if((my>=250 && my<=400)&&(mx>=200 && mx<=350)) {
				main.gameState = STATE.GAME;
				handler.allesloschen();
				handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
				handler.Objektadd(new Player(Main.breite2/2,Main.hohe2/2,ID.Player,handler, Color.blue));
				colorofPlayer = new Color(0,0,255);
			}
			if((my>=250 && my<=400)&&(mx>=800 && mx<=950)) {
				main.gameState = STATE.GAME;
				handler.allesloschen();
				handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
				handler.Objektadd(new Player(Main.breite2/2,Main.hohe2/2,ID.Player,handler, Color.white));
				colorofPlayer = new Color(255,255,255);
			}
			if((my>=250 && my<=400)&&(mx>=600 && mx<=750)) {
				main.gameState = STATE.GAME;
				handler.allesloschen();
				handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
				handler.Objektadd(new Player(Main.breite2/2,Main.hohe2/2,ID.Player,handler, Color.green));
				colorofPlayer = new Color(0,255,0);
			}
			if((my>=250 && my<=400)&&(mx>=450 && mx<=500)) {
				main.gameState = STATE.GAME;
				handler.allesloschen();
				handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
				handler.Objektadd(new Player(Main.breite2/2,Main.hohe2/2,ID.Player,handler, Color.yellow));
				colorofPlayer = new Color(255,255,0);
				
			}
			
		}
		if(HUD.LP<=0 || HUD.LP2<=0) {
			
			if((my>=400 && my<=475) && (mx>=475 && mx<=775)) {
				Gameover = 1;
				HUD.LP=100;
				HUD.LPMAX = 100;
				HUD.LP2 = 1000;
				handler.allesloschen();
				handler.Objektadd(new Player(Main.breite2/2,Main.hohe2/2,ID.Player,handler,colorofPlayer));
				handler.Objektadd(new BasicEnemy(random.nextInt((Main.breite2-100)+1)+40,random.nextInt((Main.hohe2-100)+1)+40,ID.BasicEnemy,handler));
			}
			if((my>=500 && my<=575) && (mx>=475 && mx<=775)) System.exit(1);
		
			
		}
		else {
			if(main.gameState != STATE.SHOP) {
				if((my>=0 && my<=60) && (mx>=1125 && mx<=1183)) {
					Pause = 0;
					HUD.Scoregrowth = 0;
					main.gameState = STATE.PAUSE;
					for(int i=0; i<handler.objekte.size(); i++) {
						SpielObjekt tempObjekt = handler.objekte.get(i);
						if(tempObjekt.getID()!=ID.Player) {
							tempObjekt.setspeedX(0);
							tempObjekt.setspeedY(0);
						}
					}
				}
			}
		}
		if(main.gameState == STATE.PAUSE) {
			if((my>=440 && my<=490) && (mx>=470 && mx<=730)) System.exit(1);
			if((my>=340 && my<=390) && (mx>=470 && mx<=730)) {
				main.gameState = STATE.GUI;
				handler.allesloschen();
				for(int i=0; i<20;i++) {
					handler.Objektadd(new MenuParticle(random.nextInt((Main.breite2-100)+1)-40,random.nextInt((Main.hohe2-100)+1)-40,ID.MenuParticle,handler));
				}
				HUD.LP = 100;
				HUD.LPMAX = 100;
				HUD.LP2=1000;
				HUD.Scoregrowth = 2;
				hud.LevelgrowthperScore=500;
				hud.Score = 0;
				hud.Level = 1;
				
			}
			if((my>=240 && my<=290) && (mx>=470 && mx<=730)) {
				Pause = 1;
				main.gameState = STATE.GAME;
				HUD.Scoregrowth = 2;
			}
		}
		else if (main.gameState == STATE.SHOP) {
			if((my>=200 && my<=350) && (mx>=200 && mx<=500)) {
				if(HUD.LPMAX<=190 && Coins>=500) {
					HUD.LPMAX += 10;
					Coins -= 500;
				}
				Pause = 1;
				System.out.println(HUD.LPMAX);
				main.gameState = STATE.GAME;
			}
			if((my>=200 && my<=350) && (mx>=700 && mx<=1000)) {
				Pause = 1;
				if(Coins>=1500) {
					HUD.LP = HUD.LPMAX;
					Coins -= 1500;
				}
				main.gameState = STATE.GAME;
			}
			if((my>=470 && my<=515) && (mx>=555 && mx<=665)) {
				Pause = 1;
				main.gameState = STATE.GAME;
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void tick() {
	}
	public void render(Graphics g) {
		if(main.gameState== STATE.GUI) {
			g.setFont(new Font("Monospaced",Font.PLAIN, 50));
			g.setColor(Color.red);
			g.drawRect(400,100,400,64);
		
			g.setColor(Color.white);
			g.drawString("Menü",550,50);
			g.drawString("PlayerColor",0,40);
		
			g.setColor(Color.white);
			g.drawRect(400,300,400,64);
		
			g.setColor(Color.white);
			g.drawString("Spielen",492,145);
		
			g.setColor(Color.white);
			g.drawString("Hilfe",526,345);
		
			g.setColor(Color.white);
			g.drawString("Beenden",492,545);
		
			g.setColor(Color.blue);
			g.drawRect(400,500,400,64);
			g.drawRect(0, 0, 330, 50);
			
		}
		else if(main.gameState == STATE.HELP) {
			g.setColor(Color.white);
			g.setFont(new Font("Monospaced",Font.PLAIN, 40));
			g.drawString("W,A,S,D oder Arrowkeys um Charakter zu bewegen",50,250);
			g.drawString("Escape-Taste drücken um Spiel zu schließen", 50, 350);
			g.setFont(new Font("Monospaced",Font.PLAIN, 50));
			g.drawString("Go back",Main.breite2-300,95);
			g.drawRect(900,50,220,60);
		}
		else if(main.gameState == STATE.COLORMENU) {
			g.setFont(new Font("Monospaced",Font.PLAIN, 75));
			g.setColor(Color.white);
			g.drawString("SELECT COLOR:", 0, 70);
			g.setFont(new Font("Monospaced",Font.BOLD, 23));
			g.setColor(Color.white);
			g.drawRect(200, 250, 150, 150);
			g.setColor(Color.blue);
			g.fillRect(250, 300, 50, 50);
			g.drawString("Player blue", 200, 230);
			
			g.setColor(Color.white);
			g.drawRect(400, 250, 150, 150);
			g.setColor(Color.yellow);
			g.fillRect(450, 300, 50, 50);
			g.drawString("Player yellow", 400, 230);
			
			g.setColor(Color.white);
			g.drawRect(600, 250, 150, 150);
			g.setColor(Color.green);
			g.fillRect(650, 300, 50, 50);
			g.drawString("Player green", 600, 230);
			
			g.setColor(Color.white);
			g.drawRect(800, 250, 150, 150);
			g.setColor(Color.white);
			g.fillRect(850, 300, 50, 50);
			g.drawString("Player white", 800, 230);
		}
		//Pause menü
		else if(main.gameState==STATE.PAUSE) {
			g.setFont(new Font("Monospaced",Font.PLAIN,24));
			g.setColor(new Color(255,255,0));
			g.drawString("Coins:  "+Coins, 15,135);
			g.setColor(Color.darkGray);
			g.fillRect(15,20,(int) HUD.LPMAX*2,40);
			if(hud.Level==15) {
				g.setColor(Color.white);
				g.drawRect(Main.breite2/2,20,1000/2,30);
				g.setColor(Color.darkGray);
				g.fillRect(Main.breite2/2,20,1000/2,30);
				g.setFont(new Font("Monospaced",Font.PLAIN,24));
				g.setColor(Color.RED);
				g.fillRect(Main.breite2/2,20,HUD.LP2/2,30);
				g.drawString("Drück R um zu schießen", 15, 185);	
			}
			g.setColor(new Color(150,255-(200-(int)HUD.LP),0));
			g.fillRect(15,20,(int)HUD.LP*2,40);
			g.setColor(Color.white);
			g.drawRect(15,20,(int) HUD.LPMAX*2,40);
			g.setFont(new Font("Monospaced",Font.PLAIN,24));
			g.drawString(HUD.LP+" Lebenspunkte", 15, 15);
			g.drawString("Score:  "+hud.Score, 15,85);
			g.drawString("Level:  "+hud.Level, 15,110);
			
			g.setColor(Color.white);
			g.setFont(new Font("Monospaced",Font.BOLD, 83));
			g.drawString("PAUSED", 450, 168);
			g.drawRect(450,115,300,450);
			g.drawLine(450,170,750, 170);
			
			g.setFont(new Font("Monospaced",Font.PLAIN, 50));
			g.drawRect(470,240,260,50);
			g.drawString("Resume", 515, 280);
			g.drawRect(470,340,260,50);
			g.drawString("Menü", 543, 380);
			g.drawRect(470,440,260,50);
			g.drawString("Quit", 543, 480);
		}
		//SHOP
		else if(main.gameState == STATE.SHOP) {
			g.setFont(new Font("Monospaced",Font.PLAIN,24));
			g.setColor(new Color(255,255,0));
			g.drawString("Coins:  "+Coins, 15,135);
			g.setColor(Color.darkGray);
			g.fillRect(15,20,(int) HUD.LPMAX*2,40);
			g.setColor(new Color(150,255-(200-(int)HUD.LP),0));
			g.fillRect(15,20,(int)HUD.LP*2,40);
			if(hud.Level==15) {
				g.setColor(Color.white);
				g.drawRect(Main.breite2/2,20,1000/2,30);
				g.setColor(Color.darkGray);
				g.fillRect(Main.breite2/2,20,1000/2,30);
				g.setFont(new Font("Monospaced",Font.PLAIN,24));
				g.setColor(Color.RED);
				g.fillRect(Main.breite2/2,20,HUD.LP2/2,30);
				g.drawString("Drück R um zu schießen", 15, 185);	
			}
			g.setColor(Color.white);
			g.drawRect(15,20,(int) HUD.LPMAX*2,40);
			g.setFont(new Font("Monospaced",Font.PLAIN,24));
			g.drawString(HUD.LP+" Lebenspunkte", 15, 15);
			g.drawString("Score:  "+hud.Score, 15,85);
			g.drawString("Level:  "+hud.Level, 15,110);
			g.setFont(new Font("Monospaced",Font.BOLD,24));
			g.drawString("Go back",Main.breite2/2-45,500);
			g.drawRect(Main.breite2/2-50, 470, 110, 45);
			g.setFont(new Font("Monospaced",Font.BOLD,100));
			g.setColor(Color.white);
			g.drawString("SHOP",Main.breite2/2-125,75);
			g.drawRect(200, 200, 300, 150);
			g.drawRect(700, 200, 300, 150);
			
			g.setFont(new Font("Monospaced",Font.BOLD,40));
			g.drawString("Mehr Leben", 225, 250);
			g.setFont(new Font("Monospaced",Font.BOLD,25));
			g.drawString("Cost: 500",275,335 );
			g.setFont(new Font("Monospaced",Font.BOLD,20));
			g.drawString("Click to buy", 270,275);
			
			g.setFont(new Font("Monospaced",Font.BOLD,40));
			g.drawString("Refill LP",745, 250);
			g.setFont(new Font("Monospaced",Font.BOLD,25));
			g.drawString("Cost: 1500",775,335 );
			g.setFont(new Font("Monospaced",Font.BOLD,20));
			g.drawString("Click to buy", 770,275);
		}
	}
}
