package com.graph;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph cgraph = new Graph();
		cgraph.insert_node(1);
		//System.out.println("entre =D");
			
	    cgraph.insert_node(2);
	    cgraph.insert_node(3);
	    
	    
	    cgraph.insert_edge(10,1,2,true);
	    cgraph.insert_edge(20,1,3,true);
	    cgraph.insert_edge(30,2,3,true);
	   
	    cgraph.print();
	    cgraph.remove_node(2);
	    cgraph.print();
	    
	    //cgraph.to_matrix();
	    
	    
	    /*cgraph.to_graph1();*/
	    
	    System.out.println("\n\n Ltch23 C=");

	
	}
	
}
