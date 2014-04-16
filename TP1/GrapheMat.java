package TP1;

public class GrapheMat implements Graphe {
	int NbVertex;
	public boolean[][] m;
	private Vertex[] V=new Vertex[NbVertex];

	protected GrapheMat(int n) {
		NbVertex = n;
		m = new boolean[n][n];
		
		   for(int i=0;i<NbVertex;i++) getV()[i]=new Vertex(i);
	}

	GrapheMat(GrapheLis g) {
		int n = g.succ.length;
		m = new boolean[n][n];
		for (int x = 0; x < n; ++x) {
			for (List ls = g.succ[x]; ls != null; ls = ls.suivant) {
				Vertex y = ls.val;
				m[x][y.getId()] = true;
			}
		}
	}

	// ***********************************************************
	@Override
	public boolean isEmpty() {

		return NbVertex == 0;
	}

	@Override
	public boolean isArc(Vertex s1, Vertex s2) {
		if (s1.getId() <= NbVertex && s2.getId() <= NbVertex && s1.getId() > 0
				&& s2.getId() > 0) {
			return m[s1.getId()][s2.getId()] == true
					|| m[s2.getId()][s1.getId()] == true;
		} else {
			System.out
					.println("L'un de ces deux sommets n'appartient pas au graphe");
			return false;
		}
	}

	public int degrePlus(Vertex s) {
		int alfa = 0;
		if (s.getId() <= NbVertex) {
			for (int i = 0; i < NbVertex; i++) {
				if (m[i][s.getId()])
					alfa++;
			}
			return alfa;
		} else
			return -1;
	}

	@Override
	public int degreMoins(Vertex s) {
		int beta = 0;
		if (s.getId() <= NbVertex) {
			for (int i = 0; i < NbVertex; i++) {
				if (m[s.getId()][i])
					beta++;
			}
			return beta;
		} else
			return -1;
	}

	public int degre(Vertex s) {
		if (s.getId() <= NbVertex) {
			int gamma = 0;
			for (int i = 0; i < NbVertex; i++)
				for (int j = 0; j < i; j++) {
					if (m[i][j] == m[j][i])
						gamma++;
				}
			if (gamma == NbVertex)
				return degreMoins(s);
			else
				return degreMoins(s) + degrePlus(s);
		} else
			return -1;
	}

	@Override
	public void addArc(Vertex s1, Vertex s2) {
		if (s1.getId() <= NbVertex && s2.getId() <= NbVertex && s1.getId() > 0
				&& s2.getId() > 0) {
			m[s1.getId()][s2.getId()] = true;
			System.out.println("l'arc à été ajouter ");
		} else
			System.out.println("L'une de deux sommet fait pas parti de graphe");
	}

	@Override
	public void deletArc(Vertex s1, Vertex s2) {
		if (s1.getId() <= NbVertex && s2.getId() <= NbVertex && s1.getId() > 0
				&& s2.getId() > 0) {
			m[s1.getId()][s2.getId()] = false;
			System.out.println("l'arc à été supprimer ");
		} else
			System.out.println("L'une de deux sommet fait pas parti de graphe");

	}

	@Override
	public int iemeSucc(Vertex s, int i) {
		int NbAdj = 0;
		if (s.getId() <= NbVertex && s.getId() > 0) {
			for (int j = 0; j < NbVertex; j++) {
				if (m[s.getId()][j] == true)
					NbAdj++;
				if (NbAdj == i)
					return j;
				else {
					System.out.println("Vertex s a moins de " + i
							+ " successeur ");
					return -1;
				}
			}
			System.out.println("Le vertex" + s.toString()
					+ "n'a pas de successeur ");
			return -1;
		}

		else {
			System.out.println(" le Vertex ne fait pas parti de graphe");
			return -1;
		}
	}

	@Override
	public int iemePred(Vertex s, int i) {
		int NbPred = 0;
		if (s.getId() <= NbVertex && s.getId() > 0) {
			for (int j = 0; j < NbVertex; j++) {
				if (m[j][s.getId()] == true)
					NbPred++;
				if (NbPred == i)
					return j;
				else {
					System.out.println("Vertex s a moins de " + i
							+ " predecesseur ");
					return -1;
				}
			}
			System.out.println("Le Vertex " + s.toString()
					+ " n'a pas de predecesseur");
			return -1;
		}

		else {
			System.out.println(" le Vertex ne fait pas parti de graphe");
			return -1;
		}
	}

	@Override
	public int firstSucc(Vertex s) {
		return iemeSucc(s, 0);
	}

	@Override
	public int nextSucc(Vertex s1, Vertex s2) {

		if (s1.getId() < 0 || s1.getId() > NbVertex || s2.getId() < 0
				|| s2.getId() > NbVertex) {
			System.out
					.println("C'est deux Vertex n'apparientenent pas au graphe");
			return -1;
		}

		if (!isArc(s1, s2)) {
			System.out.println("L'arret n'appartient pas au graphe");
			return -1;
		}

		for (int i = s2.getId() + 1; i < NbVertex; i++) {
			if (m[s1.getId()][s2.getId()] && m[s1.getId()][i])
				return i;
		}

		return -1;

	}

	@Override
	public int getNbVertex() {
		return this.NbVertex;
	}



	public void setV(Vertex[] v) {
		V = v;
	}

	public Vertex[] getV() {return V;
	}

}
