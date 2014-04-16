package TP1;

public interface Graphe {
	// verifier si le graphe est vide ou non
	public boolean isEmpty();

	// verifier si il existe un arc entre sommets
	public boolean isArc(Vertex s1, Vertex s2);

	// indiquer le nombre de sommets qu'on peut accéder depuis le sommet donné
	public int degrePlus(Vertex s);

	// Donner le nombre de sommets qui permettent d'accéeder aux sommets donné
	public int degreMoins(Vertex s);

	// Ajouter un arc entre deux ssommets sonnés
	public void addArc(Vertex s1, Vertex s2);

	// Supprimer un arc entre deux sommets donn_ es
	public void deletArc(Vertex s1, Vertex s2);

	// Donne le ieme successeur d'un sommet donné 
	public int iemeSucc(Vertex s, int i);

	// Donne le ieme predecesseur d'un sommet donné
	public int iemePred(Vertex s, int i);

	// Donne le premier successeur d'un sommet donné_
	public int firstSucc(Vertex s);

	// accéder au sommet suivant à partir d'un sommet et de successeur de ce
	// sommet
	public int nextSucc(Vertex s1, Vertex s2);

	// recupérer le nombre de sommets de graphe
	public int getNbVertex();

}
