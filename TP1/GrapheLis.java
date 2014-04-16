package TP1;

public class GrapheLis implements Graphe {
	private int NbVertex;
	public List[] succ;
	public Vertex[] V;

	public GrapheLis(int n) {
		this.NbVertex = n;
		this.succ = new List[n];
		this.V = new Vertex[n];
		for (int i = 0; i < NbVertex; i++)
			V[i] = new Vertex(i);
	}
	//****** de matrice boolean au listes d'adjacences********
	GrapheLis (GrapheMat g) {
		int n = g.m.length;
		List[] succ = new List[n];
		for (int i = 0; i < n; i++) {
		for (int j = n-1; j >= 0; --j)
		if (g.m[i][j])
		 succ[i] = new List (new Vertex(j), succ[i]);
		}
		}
	@Override
	public boolean isEmpty() {

		return NbVertex == 0;
	}

	@Override
	public boolean isArc(Vertex s1, Vertex s2) {
		if (s1.getId() <= NbVertex && s2.getId() <= NbVertex && s1.getId() > 0
				&& s2.getId() > 0) {
			for (List ls = succ[s1.getId()]; ls != null; ls = ls.suivant) {
				Vertex y = ls.val;
				if (y == s2)
					return true;
			}
		}
		return false;
	}

	@Override
	public int degrePlus(Vertex s) {
		int alfa = 0;
		if (s.getId() >= 0 && s.getId() <= NbVertex) {
			for (List ls = succ[s.getId()]; ls != null; ls = ls.suivant, alfa++) {
			}
			System.out.println("degree+ =" + alfa);
			return alfa;
		}
		System.out.println("degree + = -1 ");
		return -1;

	}

	@Override
	public int degreMoins(Vertex s) {
		if (s.getId() > 0 && s.getId() <= NbVertex) {
			int beta = 0;

			for (int i = 0; i != s.getId() && i < NbVertex; i++) {
				for (List ls = succ[i]; ls != null; ls = ls.suivant) {
					Vertex y = ls.val;
					if (y == s)
						beta++;
				}
			}

			return beta;
		} else
			return -1;
	}

	@Override
	public void addArc(Vertex s1, Vertex s2) {

		for (List ls = succ[s1.getId()]; ls != null; ls = ls.suivant) {
			if (ls.suivant == null) {
				System.out.println("je suis en boucle");
				ls.suivant = new List(s2, null);
				return;

			}
		}

	}

	@Override
	public void deletArc(Vertex s1, Vertex s2) {
		for (List ls = succ[s1.getId()]; ls != null; ls = ls.suivant) {
			// premier cas si l'élément est en tête de la liste chainée
			if (ls.val.getId() == s2.getId()) {
				while (ls.suivant.suivant != null) {
					ls.val = ls.suivant.val;
					ls = ls.suivant;
					if (ls.suivant.suivant == null) {
						ls.val = ls.suivant.val;
						ls.suivant = null;
					}
					return;
				}

			}
			// deuxième cas si l'élément n'est pas le premier
			// on aurait dû utilise les listes doublement chainé pour ne pas
			// discuter les cas !!
			if (ls.suivant.val == s2) {
				ls.suivant = ls.suivant.suivant;
				return;
			}

		}

	}

	@Override
	public int iemeSucc(Vertex s, int i) {
		if (i >= 0 && i < degrePlus(s)) {
			int cpt = 1;
			for (List ls = succ[s.getId()]; ls != null; ls = ls.suivant, cpt++) {

				if (cpt == i) {
					System.out.println("V["+ls.val.getId()+"]");// afin de vérifié
					return ls.val.getId();
				}
			}
		}
		return -1;
	}

	@Override
	public int iemePred(Vertex s, int i) {
		int cpt = 0;
		for (int j = 0; j < NbVertex; j++)
			for (List ls = succ[j]; ls != null; ls = ls.suivant) {
				Vertex y = ls.val;
				if (y == s)
					cpt++;
				if (cpt == i)
					return y.getId();
			}
		return -1;
	}

	@Override
	public int firstSucc(Vertex s) {
		return iemeSucc(s, 1);
	}

	@Override
	public int nextSucc(Vertex s1, Vertex s2) {
		for (List ls = succ[s1.getId()]; ls != null; ls = ls.suivant) {
			if (ls.val == s2 && ls.suivant != null)
				return ls.suivant.val.getId();
		}
		return -1;
	}

	@Override
	public int getNbVertex() {
		return NbVertex;

	}

	// méthode affiche les listes enchainées d'un graphe
	void ListToString() {
		for (int i = 0; i < NbVertex; i++) {
			List s = succ[i];
			StringBuilder sb = new StringBuilder("");
			sb.append("succ[" + i + "]=<");
			while (s != null) {
				sb.append(s.val.getId());
				if (s.suivant != null)
					sb.append(" , ");
				s = s.suivant;
			}
			sb.append(" >");
			System.out.println(sb.toString());
		}
	}
}
