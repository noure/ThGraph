package TP1bis;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Graphe extends JPanel {
	Sommet[] s;
	Arrete[] a;

	public Graphe(Sommet[] s, Arrete[] a) {
		this.s = s;
		this.a = a;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		for (Arrete arr : a) {
			arr.paintComponent(g);
		}
		for (Sommet som : s) {
			som.paintComponent(g);
		}
	}
}