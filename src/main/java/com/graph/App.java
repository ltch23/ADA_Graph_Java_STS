package com.graph;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph cgraph = new Graph();
		
		
		cgraph.insert_node(1);
		cgraph.insert_node(2);
	    cgraph.insert_node(3);
	    cgraph.insert_node(4);
	    
	//    cgraph.insert_node(6);
	    
	    cgraph.insert_edge(10,1,2,false);
	    cgraph.insert_edge(20,1,3,false);
	    cgraph.insert_edge(30,1,4,false);
	    cgraph.insert_edge(40,2,3,false);
	    cgraph.insert_edge(50,2,4,false);
	    cgraph.insert_edge(60,3,4,false);

	    cgraph.print();
	       
	    cgraph.to_matrix();
	    //cgraph.kruskal();
	    cgraph.prim();
	    
	    /*cgraph.to_graph1();*/
	    
	    System.out.println("\n\n Ltch23 C=");

	
	}
	
}
