package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Boss1 extends SpielObjekt{
	
	private int timer = 80;
	private int delay = 100;
	private int speed,speed2;
	
	public Boss1(int x, int y, ID id,Handler handler) {
		super(x, y, id,handler);
		this.handler = handler;
		speed = 0;
		speed2 = 2;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,100,100);
	}
	private void collision() {
		for(int i=0; i<handler.objekte.size();i++) {
			
			SpielObjekt tempObjekt = handler.objekte.get(i);
			if(tempObjekt.getID() == ID.PlayerBullet ) {
				if(getBounds().intersects(tempObjekt.getBounds())) {
					if(Menu.Pause!=0) {
						if(HUD.LP2>0) HUD.LP2-= 0.5;
						else if(HUD.LP2<=0) HUD.LP2=0;
					}
				}
			}
		}
	}
	@Override
	public void tick() {

		if(Menu.Pause == 0) {
			speed=0;
			speed2=0;
			speedx=speed;
			speedy=speed2;
		}
		else {
			if(timer <= 0) {
				speed2=0;
			}
			else timer--;
			
			if(timer <= 0) delay--;
			
			if(delay <= 0) {
				if(speed==0) {
					speed=2;
				}
				double spawn = Math.random()*100;
				if(spawn>95) handler.Objektadd(new Bullet1(x+50,y+50,ID.Bullet1,handler));
				if(spawn>95) handler.Objektadd(new Bullet2(x+50,y+50,ID.Bullet2,handler));
			}
			speedx=speed;
			speedy=speed2;
			collision();
			
		}
		
		x += speedx;
		y += speedy;
		

		
		if(x<=0 || x>=Main.breite2-100) speed *= -1;
		
		//handler.Objektadd(new Trail(x,y,24,24,ID.Trail,handler,Color.red,0.05f));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(x,y,100,100);
		
	}
	
}
