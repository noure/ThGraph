package TP2;

import java.util.LinkedList;

import TP1.GrapheLis;
import TP1.List;
import TP1.Vertex;

public class MainTP2 {
public static void main(String arg[]){
	GrapheLis g=new GrapheLis(6);
	g.succ[0]=new List(g.V[1],new List(g.V[2],null)); 
	g.succ[1]=new List(g.V[2],new List(g.V[5],new List(g.V[3], null)));
	g.succ[2]=new List(g.V[5],null);
	g.succ[3]=new List(g.V[4],null);
	g.succ[4]=new List(g.V[1],null);
	g.succ[5]=new List(g.V[3],null);
   
	BFS.showBFS( g,g.V[2]);
	BFS.showBFS( g,g.V[1]);
	
	BFS.bfs_CChemin(g, g.V[2]);
    BFS.bfs_CChemin(g, g.V[1]);
   
  
   
}
}
