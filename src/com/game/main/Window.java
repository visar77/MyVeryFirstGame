package com.game.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	private static final long serialVersionUID = -1478604005915452565L;
	
	public Window(int breite, int hohe, String Titel, Main game) {
		JFrame w = new JFrame(Titel);
		
		w.setPreferredSize(new Dimension(breite,hohe));
		w.setMaximumSize(new Dimension(breite,hohe));
		w.setMinimumSize(new Dimension(breite,hohe));

		
		
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setResizable(false);
		w.setLocationRelativeTo(null);
		w.add(game);
		w.setVisible(true);
		game.startino();
	}

	

}
