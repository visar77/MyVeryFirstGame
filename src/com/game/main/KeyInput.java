package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.game.main.Main.STATE;

public class KeyInput extends KeyAdapter{
	
	private Main main;
	private Handler handler;
	private HUD hud;
	private SpielObjekt player;
	private boolean oben = false;
	private boolean unten = false;
	private boolean links = false;
	private boolean rechts = false;
	public static double speed;
	public static double minusspeed;
	
	public KeyInput(Handler handler, Main main, HUD hud) {
		this.handler = handler;
		this.main = main;
		this.hud = hud;
	}
	public void keyPressed(KeyEvent e) {
		if(Menu.Pause == 1) {
			speed = 3.5;
			minusspeed = -1*speed;
		}
		else if(Menu.Pause == 0) {
			speed = 0;
			minusspeed = 0;
		}
		int key = e.getKeyCode();
		for(int i=0; i<handler.objekte.size();i++) {
			SpielObjekt tempObjekt = handler.objekte.get(i);
			if(tempObjekt.getID()==ID.Player) {
				if(HUD.LP>0) {
					if(key == KeyEvent.VK_W ) {
						oben = true;
						tempObjekt.setspeedY( minusspeed);
					}
					else if(key == KeyEvent.VK_A ) {
						links = true;
						tempObjekt.setspeedX(minusspeed);
					}
					else if(key == KeyEvent.VK_S ) {
						unten = true;
						tempObjekt.setspeedY(speed);
					}
					else if(key == KeyEvent.VK_D ) {
						rechts = true;
						tempObjekt.setspeedX(speed);
					}
					
				}
				if(key == KeyEvent.VK_ESCAPE) System.exit(1);
				if(key == KeyEvent.VK_SPACE) {
					if(main.gameState != STATE.PAUSE) {
						main.gameState = STATE.SHOP;
						Menu.Pause = 0;
					}
				}
				if(key == KeyEvent.VK_R) {
					if(main.gameState == STATE.GAME) {
						if(hud.Level==15) {
							for(int a=0; a<handler.objekte.size();a++) {
								if(handler.objekte.get(a).getID() == ID.Player) player = handler.objekte.get(a);
							}
							handler.Objektadd(new PlayerBullet(player.x+16,player.y+16,ID.PlayerBullet,handler));
						}
					}
				}
				
			
			}
		}
		
	}
	public void keyReleased(KeyEvent e) {
		if(Menu.Pause == 1) {
			speed = 4.5;
			minusspeed = -1*speed;
		}
		else if(Menu.Pause == 0) {
			speed = 0;
			minusspeed = 0;
		}
		int key = e.getKeyCode();
		if(HUD.LP>0) {
			for(int i=0; i<handler.objekte.size(); i++) {
				SpielObjekt tempObjekt = handler.objekte.get(i);
			
				if(tempObjekt.getID() == ID.Player) {
				
					if(key == KeyEvent.VK_W) {
						oben = false;
						if(unten) {
							tempObjekt.setspeedY(speed);
						}
						else {
							tempObjekt.setspeedY(0);
						}
					}
				
					else if(key == KeyEvent.VK_S) {
						unten = false; 
						if(oben) {
							tempObjekt.setspeedY(minusspeed);
						}
						else {
							tempObjekt.setspeedY(0);
						}
					}
				
					else if(key == KeyEvent.VK_A) {
						links = false; 
						if(rechts) {
							tempObjekt.setspeedX(speed);
						}
						else {
							tempObjekt.setspeedX(0);
						}
					}
				
					else if(key == KeyEvent.VK_D) {
						rechts = false;
						if(links) {
							tempObjekt.setspeedX(minusspeed);
						}
						else {
							tempObjekt.setspeedX(0);
						}
					}
				
				}
			}
		}
	}
}
