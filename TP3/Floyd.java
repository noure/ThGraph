package TP3;


public class Floyd {
	static double[][] distancesMinimales_Floyd(GrapheMatVal g) {
		int n = g.d.length;
		for (int k = 0; k < n; k++)
		for (int i = 0; i < n; i++)
		for (int j = 1; j < n; j++)
		g.d[i][j] = Math.min(g.d[i][j], g.d[i][k] + g.d[k][j]);
	
		
		return g.d;
	}
	static double[][] distancesMaximal_Floyd(GrapheMatVal g) {
		int n = g.d.length;
		for (int k = 0; k < n; k++)
		for (int i = 0; i < n; i++)
		for (int j = 1; j < n; j++)
		g.d[i][j] = Math.max(g.d[i][j], g.d[i][k] + g.d[k][j]);
	
		
		return g.d;
	}
}
