package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AIEnemy extends SpielObjekt{
	
	private Handler handler;
	private SpielObjekt player;
	private int speed,speed2;
	
	public AIEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id,handler);
		this.handler = handler;
		for(int i=0; i<handler.objekte.size();i++) {
			if(handler.objekte.get(i).getID() == ID.Player) player = handler.objekte.get(i);
		}
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}
	@Override
	public void tick() {
		
		float DiffX = x - player.x -4;
		float DiffY = y - player.y -4;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		speed = (int) ((-1/distance) * DiffX *2.5);
		speed2 = (int) ((-1/distance) * DiffY *2.5);
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
		
		if(x<=0 || x>=Main.breite2-38) speedx *= -1;
		if(y<=0 || y>=Main.hohe2-58) speedy *= -1;
		
		handler.Objektadd(new Trail(x,y,24,24,ID.Trail,handler,Color.cyan,0.05f));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.cyan);
		g.fillRect(x,y,16,16);
		
	}
	
	
	
}
