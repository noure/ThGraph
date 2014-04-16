package TP1bis;

import java.awt.Color;
import java.awt.Graphics;

public class Sommet implements drawable {
	public static int width = 15;
	public static int height = 15;
	public static int compteur = 1;
	public int id;
	public int posX;
	public int posY;

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Sommet(int posX, int posY) {
		id = compteur++;
		this.posX = posX;
		this.posY = posY;
	}

	public Sommet() {
		this(0, 0);
	}

	public String toString() {
		return "le sommet " + id + " avec les coordonnées " + posX + ", "
				+ posY;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(posX, posY, width, height);
	}
}