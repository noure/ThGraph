package TP1bis;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	JPanel pan;
	public Fenetre(Sommet[]s , Arrete[]a) {
		this.setTitle("TP1bis");
		this.setSize(400,400);
		pan=new Graphe(s,a);
		this.getContentPane().add(pan);
	}

}