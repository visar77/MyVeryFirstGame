package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerBullet extends SpielObjekt{
	
	private int speed2;
	
	public PlayerBullet(int x, int y, ID id,Handler handler) {
		super(x, y, id,handler);
		this.handler = handler;
		speed2 = -10;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,24,24);
	}
	@Override
	public void tick() {
		if(Menu.Pause == 1) {
			speedy = speed2;
		}
		else if(Menu.Pause == 0) {
			speedy = 0;
		}
		y += speedy;
		
		if(x<=0 || x>=Main.breite2-38) handler.Objektloschen(this);
		
		//handler.Objektadd(new Trail(x,y,24,24,ID.Trail,handler,Color.red,0.05f));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.fillRect(x,y,24,24);
		
	}
	
	
	
}
