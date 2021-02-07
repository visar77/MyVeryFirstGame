package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends SpielObjekt{
	
	private int speed,speed2;
	
	public BasicEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id,handler);
		this.handler = handler;
		speed = 4;
		speed2 = 4;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,24,24);
	}
	@Override
	public void tick() {
		if(Menu.Pause == 1) {
			speedx = speed;
			speedy = speed2;
		}
		else if(Menu.Pause == 0) {
			speedx = 0;
			speedy = 0;
		}
		x += speedx;
		y += speedy;
		
		if(x<=0 || x>=Main.breite2-38) speed *= -1;
		if(y<=0 || y>=Main.hohe2-58) speed2 *= -1;
		
		//handler.Objektadd(new Trail(x,y,24,24,ID.Trail,handler,Color.red,0.05f));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(x,y,24,24);
		
	}
	
	
	
}
