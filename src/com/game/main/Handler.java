package com.game.main;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

public class Handler {
	LinkedList<SpielObjekt> objekte = new LinkedList<SpielObjekt>();
	
	public void tick() {

		for (int i=0; i<objekte.size();i++) {
			SpielObjekt tempObjekt = objekte.get(i);
			tempObjekt.tick();
		}
		
	}
	public void render(Graphics g) {

		for (int i=0; i<objekte.size();i++) {
			SpielObjekt tempObjekt = objekte.get(i);
			tempObjekt.render(g);
		}
	}
	public void Objektadd(SpielObjekt objekte) {
		
		this.objekte.add(objekte);
	}
	public void Objektloschen(SpielObjekt objekte) {
		this.objekte.remove(objekte);
	}
	public void allesloschen() {
		this.objekte.removeIf(tempObjekt -> tempObjekt.getID() != ID.Nothing);
	}
	public void allesloschen2() {
		this.objekte.removeIf(tempObjekt -> tempObjekt.getID() != ID.Player);
	}
}
