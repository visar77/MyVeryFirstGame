package com.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class SpielObjekt {
	
	protected int x,y;
	protected ID id;
	protected double speedx,speedy;
	protected Handler handler;
	
	public SpielObjekt(int x, int y,ID id, Handler handler) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.handler = handler;
		handler.Objektadd(this);
	}
	

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setID(ID id) {
		this.id = id;

}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public ID getID() {
		return id;
	}
	public void setspeedX(double speedx) {
		this.speedx = speedx;
	}
	public void setspeedY(double speedy) {
		this.speedy = speedy;
	}
	public double getspeedX() {
		return speedx;
	}
	public double getspeedY() {
		return speedy;
	}

	}
