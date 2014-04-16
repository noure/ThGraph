package TP1bis;

import javax.swing.JFrame;

public class MainTP1bis {

	public static void main(String[] args) {
		int i, j;
		Sommet[] s = new Sommet[10];
		for (i = 0; i < 10; i++) {
			s[i] = new Sommet(40, 80);
		}
		int matrix[][] = new int[10][10];
		for (i = 0; i < 10; i++) {
			matrix[i][i] = 0;
		}
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				if (i != j) {
					matrix[i][j] = 1;
				}
			}
		}
		for (i = 4; i < 6; i++) {
			for (j = 4; j < 6; j++) {
				if (i != j) {
					matrix[i][j] = 0;
				}
			}
		}
		for (i = 6; i < 10; i++) {
			for (j = 6; j < 10; j++) {
				if (i != j) {
					matrix[i][j] = 1;
				}
			}
		}
		// tableau de sommet
		s[0] = new Sommet(120, 230);
		s[1] = new Sommet(130, 340);
		s[2] = new Sommet(150, 160);
		s[3] = new Sommet(170, 180);
		s[4] = new Sommet(130, 140);
		s[5] = new Sommet(190, 150);
		s[6] = new Sommet(120, 230);
		s[7] = new Sommet(150, 160);
		s[8] = new Sommet(170, 190);
		s[9] = new Sommet(200, 210);
		Arrete[] arr = new Arrete[100];
		int index = 0;
		for (i = 0; i < 10; i++) {
			for (j = 0; j < 10; j++) {
				if (matrix[i][j] == 1)
					arr[index] = new Arrete(s[i], s[j]);
				else
					arr[index] = new Arrete(s[0], s[0]);
				index++;
			}
		}
		 JFrame fen=new Fenetre(s,arr);;
		fen.setVisible(true);
		fen.setSize(400, 400);
		//fen.setDefaultCloseOperation();
	}
}
