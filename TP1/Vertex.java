package TP1;

public class Vertex {
	public static int  COMPTEUR=0;
	int Id; 
	String name;
	
	public Vertex(int n){
		while(n<COMPTEUR){
			n++;
		}
		    this.Id=n;
		    this.name="name S"+Integer.toString(n);
			COMPTEUR++;	  
	  }
	
      public int getId(){
    	  return Id;
    	       }
      public String getName(){
    	  return name;
      }
      public String ToString(){
    	  return "S"+Id;
      }
}
