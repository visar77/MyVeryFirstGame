package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

public class BasicEnemy2 extends SpielObjekt{
	
	private int speed,speed2;
	
	public BasicEnemy2(int x, int y, ID id,Handler handler) {
		super(x, y, id,handler);
		this.handler = handler;
		speed = 5;
		speed2 = 5;
	}
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,30,15);
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
		
		//handler.Objektadd(new Trail(x,y,32,32,ID.Trail,handler,Color.yellow,0.05f));
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Polygon dreieck = new Polygon();
		dreieck.addPoint(x, y);
	    dreieck.addPoint(x+30, y);
	    dreieck.addPoint(x+15, y+30);
		g2d.setColor(Color.yellow);
		g2d.fill(dreieck);
		
	}
	
	
	
}

