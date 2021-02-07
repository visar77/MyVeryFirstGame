package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends SpielObjekt{
	
	private Color color;

	public Player(int x, int y, ID id,Handler handler, Color color) {
		super(x, y, id, handler);
		this.handler = handler;
		this.color = color;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	private void collision() {
		for(int i=0; i<handler.objekte.size();i++) {
			
			SpielObjekt tempObjekt = handler.objekte.get(i);
			if(tempObjekt.getID() == ID.BasicEnemy || tempObjekt.getID() == ID.BasicEnemy2 || tempObjekt.getID() == ID.Bullet2 || tempObjekt.getID() == ID.Bullet1) {
				if(getBounds().intersects(tempObjekt.getBounds())) {
					if(Menu.Pause!=0) {
						if(HUD.LP>0) HUD.LP -= 1;
						else if(HUD.LP==0) HUD.LP=0;
					}
				}
			}
			else if( tempObjekt.getID() == ID.AIEnemy) {
				if(getBounds().intersects(tempObjekt.getBounds())) {
					if(Menu.Pause!=0) {
						if(HUD.LP>0) HUD.LP -= 0.25;
						else if(HUD.LP==0) HUD.LP=0;
					}
				}
			}
			
			
			
		}
	}
	
	@Override
	public void tick() {
		
		x += speedx;
		y += speedy;
		
		if(x>= Main.breite2-48) x = Main.breite2-48;
		
		else if(x<=0) x = 0;
		
		if(y>= Main.hohe2-70) y = Main.hohe2-70;
		
		else if(y<=0) y = 0;
		
		collision();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 32, 32);
	}

}
