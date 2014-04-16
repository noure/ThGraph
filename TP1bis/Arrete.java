package TP1bis;

import java.awt.Color;
import java.awt.Graphics;

public class Arrete implements drawable {
	Sommet src;
	Sommet desc;

	public Arrete(Sommet src, Sommet desc) {
		this.src = src;
		this.desc = desc;
	}

	public String toString() {
		return "je suis l'arc reliant" + src + " à " + desc;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(src.getPosX(), src.getPosY(), desc.getPosX(), desc.getPosY());
	}
}