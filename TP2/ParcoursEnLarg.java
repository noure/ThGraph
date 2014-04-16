package TP2;
import TP1.*;

import java.util.Arrays;
import java.util.Queue; 
import java.util.LinkedList;



public class ParcoursEnLarg {
	final static int BLANC = 0, GRIS = 1, NOIR = 2;
	int numOrdre = -1;
	static int[ ] largeurPref (GrapheLis g, Vertex x) {
		int n = g.succ.length, numOrdre = -1;
		int[ ] couleur = new int[n], num = new int[n];
		/*on coulore tous les points en blanc*/
		for (int x1 = 0; x1 < n; x1++) couleur[x1] = BLANC;
		Queue<Vertex> f = new LinkedList<Vertex>();
		couleur[x.getId()] = GRIS; // le sommet pris la couleur gris pr dire visité 
		f.add(x);       // on l'ajoute au file
		while ( !f.isEmpty() ) {
		x = f.remove();   // on défile f
		num[x.getId()] = numOrdre++ +2 ;  // sa distance 
		for (List ls = g.succ[x.getId()]; ls != null; ls = ls.suivant) {
		Vertex y = ls.val;
		if (couleur[y.getId()] == BLANC) {
		couleur[y.getId()] = GRIS;
		f.add(y);
		}
		}
		couleur[x.getId()] = NOIR;
		}
		System.out.println(Arrays.toString(num));
		return num;
		}
}
