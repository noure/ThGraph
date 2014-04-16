package TP1;

public class Main {
public static void main(String args[]){
	GrapheLis g=new GrapheLis(6);
	g.succ[0]=new List(g.V[1],new List(g.V[2],null)); 
	g.succ[1]=new List(g.V[2],new List(g.V[5],new List(g.V[3], null)));
	g.succ[2]=new List(g.V[5],null);
	g.succ[3]=new List(g.V[4],null);
	g.succ[4]=new List(g.V[1],null);
	g.succ[5]=new List(g.V[3],null);
 	g.addArc(g.V[0], g.V[4]);
  System.out.println("***************Avant modification****************** "); 
 	g.ListToString();
 	System.out.println("*************Suppression de l'arc (1,2)************** ");
	g.deletArc(g.V[1],g.V[2]);
	g.ListToString();
	System.out.println("*************Calcul de degreeplus de V[1]************** ");
    g.degrePlus(g.V[0]);
    System.out.println("*************2ieme successeur de V[1]****************** ");
    g.iemeSucc(g.V[1],1);

	}
}