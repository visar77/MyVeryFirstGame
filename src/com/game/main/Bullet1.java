package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bullet1 extends SpielObjekt{
	
	private Handler handler;
	private static Random random = new Random();
	private int speed,speed2;
	
	public Bullet1(int x, int y, ID id,Handler handler) {
		super(x, y, id,handler);
		this.handler = handler;
		speed = (random.nextInt(4 - -4)+ -4);
		speed2 = 4;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,15,15);
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
		
		
		
		if(y >=(Main.hohe2-16)) handler.Objektloschen(this);
		//handler.Objektadd(new Trail(x,y,24,24,ID.Trail,handler,Color.red,0.15f));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(x,y,15,15);
		
	}
	
	
	
}
