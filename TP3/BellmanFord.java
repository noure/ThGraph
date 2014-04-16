package TP3;

import TP1.*;

public class BellmanFord {
	public static void distancesMinimales_Bellman(GrapheMatVal g, Vertex source) {

		Vertex[] Pred = new Vertex[g.m.length];
		double[] Dist = new double[g.m.length];
		for (int k = 1; k < g.m.length; k++)
			for (int x = 0; x < g.m.length; x++)
				for (int y = g.firstSucc(g.getV()[x]); y <= g.iemeSucc(
						g.getV()[x], g.degrePlus(g.getV()[x])); y++) {

					Dist[y] = Math.min(Dist[y], Dist[x] + g.d[x][y]);

				}

	}

}
