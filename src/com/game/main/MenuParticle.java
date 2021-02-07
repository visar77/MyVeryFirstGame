package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends SpielObjekt{
	
	private Random random;
	private Color col;
	
	public MenuParticle(int x, int y, ID id,Handler handler) {
		super(x, y, id,handler);
		this.handler = handler;
		random = new Random();
		speedx = random.nextInt((5 + -5)+1)-5;
		speedy = random.nextInt((5 + -5)+1)-5;
		col = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,24,24);
	}
	@Override
	public void tick() {
		
		x += speedx;
		y += speedy;
		
		if(x<=0 || x>=Main.breite2-38) speedx *= -1;
		if(y<=0 || y>=Main.hohe2-58) speedy *= -1;
		
		handler.Objektadd(new Trail(x,y,24,24,ID.Trail,handler,col,0.1f));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(col);
		g.fillRect(x,y,24,24);
		
	}
	
	
	
}
