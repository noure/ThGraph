package TP3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import TP1.*;

public class Dijkstra {

	public void computPath(GrapheLisVal g, Vertex source) {
		Vertex[] Pred = new Vertex[g.getNbVertex()];
		double[] Dist = new double[g.getNbVertex()];
		for (int k = 1; k < g.getNbVertex(); k++) {
			Pred[k] = new Vertex(-1);
			Dist[k] = Double.POSITIVE_INFINITY;
		}

		Dist[source.getId()] = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(source);

		while (!pq.isEmpty()) {
			Vertex v = pq.poll();
			for (List ls = g.succ[v.getId()]; ls != null; ls = ls.suivant) {
				double DistanceTroughtLs = Dist[ls.val.getId()]
						+ g.poids[v.getId()][ls.val.getId()];
				if (DistanceTroughtLs < Dist[ls.val.getId()]) {
					pq.remove(ls);
					Dist[ls.val.getId()] = DistanceTroughtLs;
					Pred[ls.val.getId()] = v;
					pq.add(ls.val);
				}

			}

		}
	}

}