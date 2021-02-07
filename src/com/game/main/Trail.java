package com.game.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends SpielObjekt{
	
	private float alpha = 1;
	private Color color;
	private int breite;
	private int hohe;
	private float leben;
	
	private Handler handler;

	public Trail(int x, int y, int breite, int hohe, ID id, Handler handler,Color color,float leben) {
		super(x, y, id, handler);
		this.handler = handler;
		this.color = color;
		this.hohe = hohe;
		this.breite = breite;
		this.leben = leben;
		
		
	}

	@Override
	public void tick() {
		if(alpha>leben) {
			alpha -= leben - 0.001f;
		} else handler.Objektloschen(this);
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect(x, y, breite,hohe);
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type,alpha);
		
	}

	@Override
	public Rectangle getBounds() {
		
		return null;
	}
	
	

}
