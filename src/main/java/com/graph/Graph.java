package com.graph;

import java.util.*;


public class Graph {

	public Vector<Node> g_nodes= new Vector<Node>();
	public Vector<Edge> g_edges= new Vector<Edge>();

	public int cont=0;
	public Vector<Integer> vec_node= new Vector<Integer>();
	   
	
    
	public boolean insert_node(int n_data ){
    
    	Node Nodo = new Node(n_data);
    	g_nodes.addElement(Nodo);
        cont++;
    	return true;
    	
    }
    public boolean insert_edge(int n_data,int node_a,int node_b, boolean dir){
    	Node Nodea=null;
    	Node Nodeb=null;
        for(int i=0; i<g_nodes.size(); i++){
            if(g_nodes.get(i).n_data==node_a) Nodea=g_nodes.get(i);
            if(g_nodes.get(i).n_data==node_b) Nodeb=g_nodes.get(i);
        }
        
        Edge new_edge = new Edge(n_data,Nodea,Nodeb,dir);
        Nodea.n_edges.addElement(new_edge);
        Nodeb.n_edges.addElement(new_edge);
        g_edges.addElement(new_edge);
        return true;
    }
    
    public boolean remove_edge(int _data,int node_a ,int node_b){
    	Node Na,Nb; Na=Nb=null;
        for(int i=0; i<g_nodes.size(); i++){
            if(g_nodes.get(i).n_data==node_a) Na=g_nodes.get(i);
            if(g_nodes.get(i).n_data==node_b) Nb=g_nodes.get(i);
        }
        
        /*for(int i=0; i<g_nodes.size(); i++)
            for(int j=0; j<g_nodes.get(i).n_edges.size(); j++)
                if(g_nodes.get(i).n_edges.get(j).e_data==_data && g_nodes.get(i).n_edges.get(j).e_node[0]==Na && g_nodes.get(i).n_edges.get(j).e_node[1]==Nb)
                g_nodes.get(i).n_edges.remove(j);*/
        
        
        for(int i=0; i<g_edges.size(); i++){
            Edge delete_node=null;
        	if(g_edges.get(i).e_data ==_data && g_edges.get(i).e_node[0]==Na && g_edges.get(i).e_node[1]==Nb){
                delete_node=g_edges.get(i);
                g_edges.remove(i);
                delete_node=null;
            }
        }
        return true;	
    }
    
   
   public boolean remove_node(int _data){
   Node delete_node=null;
           
        for(int i=0; i<g_nodes.size(); i++)
        {
            if(g_nodes.get(i).n_data==_data){
                delete_node= g_nodes.get(i);   
            	for(int j=0; j<g_nodes.get(i).n_edges.size(); j++)
                	remove_edge( g_nodes.get(i).n_edges.get(j).e_data, g_nodes.get(i).n_edges.get(j).e_node[0].n_data,  g_nodes.get(i).n_edges.get(j).e_node[1].n_data);
                g_nodes.remove(i);
                delete_node=null;
            }
        }
        	cont--;
   	return true;
    }
    
    public void print(){
    	System.out.println("Grafo");
    	System.out.println("Nodo");
    	for(int i=0; i<g_nodes.size();i++)
    	    System.out.print(g_nodes.get(i).n_data+ " ");
    	    System.out.println(" ");
	    	System.out.println("Aristas");
    	    for(int i=0; i<g_edges.size(); i++){
    	    	System.out.print(g_edges.get(i).e_node[0].n_data);
    	    	System.out.print(" -- "+g_edges.get(i).e_data);
    	    	System.out.print(" --> "+g_edges.get(i).e_node[1].n_data+"\n");
    	        if(!g_edges.get(i).e_dir){
    	            System.out.print(g_edges.get(i).e_node[1].n_data);
    	        	System.out.print("  -- "+ g_edges.get(i).e_data);
    	        	System.out.print(" -->  "+g_edges.get(i).e_node[0].n_data+"\n");
    	            }
    	    }
    }
	
    public void to_matrix(){
        int [][] matrix= new int[cont][cont];
        for(int i=0; i<cont; i++)
        	for(int j=0; j<cont; j++)
        		matrix[i][j]=0;
    	for(int i=0; i<g_edges.size(); i++){
            int aux1,aux2;
            aux1=aux2=0;
            for(int j=0;j<g_nodes.size();j++){
            	if((g_edges.get(i).e_node[0].n_data)== g_nodes.get(j).n_data) aux1=j;
    			if((g_edges.get(i).e_node[1].n_data)== g_nodes.get(j).n_data) aux2=j;
    			}
            matrix[aux1][aux2]=g_edges.get(i).e_data;
            if(!g_edges.get(i).e_dir)
                matrix[aux2][aux1]=g_edges.get(i).e_data;
        }
       
    	System.out.println("Grafo a Matriz");
    	System.out.print("   ");
    	for(int i=0; i<g_nodes.size();i++)
    		System.out.print(g_nodes.get(i).n_data+" ");
    	System.out.println("   ");
        for(int i=0; i<g_nodes.size();i++)
        	System.out.print("-  ");
        System.out.println(" ");
		       
        for(int i=0;i<cont;i++){
        	System.out.print(g_nodes.get(i).n_data+ "| ");
        	for(int j=0;j<cont;j++)
        		System.out.print(matrix[i][j]+ " ");
        	System.out.println(" ");
    	}
     /*for (int i=0;i<vec_nodes.size();i++)
    	{cout<<vec_nodes[i]<<" ";}
    */
    }
    
    public void to_graph1(){
       
    vec_node.add(10); 	insert_node(10);
    vec_node.add(20); 	insert_node(20);
    vec_node.add(30); 	insert_node(30);    
    
        
    int [][] matrix= new int[vec_node.size()][vec_node.size()];
      
    for(int i=0; i<vec_node.size(); i++)
       for(int j=0; j<vec_node.size(); j++)
          matrix[i][j]=0;
        
    matrix[0][1]=1;
    matrix[1][0]=1;
    matrix[1][2]=2;
    matrix[2][1]=2;
    matrix[0][2]=3;

    System.out.println("Matriz a Grafo");
    System.out.print("  ");
	
    for(int i=0;i<vec_node.size();i++)
    	System.out.print(vec_node.get(i)+" ");
    System.out.println("");
    System.out.print("  ");
    for(int i=0; i<vec_node.size();i++)
    	System.out.print(" -");
    System.out.println();
    
    for(int i=0;i<vec_node.size();i++){
    	System.out.print(vec_node.get(i)+"| ");
    	for(int j=0;j<vec_node.size();j++)
    		System.out.print(matrix[i][j]+" ");
    	System.out.println(" ");
    }
    
    for(int i=0;i<vec_node.size();i++){
	   for(int j=0;j<vec_node.size();j++){
                int edgex=0;
                if(matrix[i][j]!=0){
                    edgex=matrix[i][j];
                    if(matrix[j][i]==edgex){
                        matrix[j][i]=matrix[i][j]=0;
                        insert_edge(edgex,vec_node.get(i), vec_node.get(j),false);
                        }
                    else
                        insert_edge(edgex,vec_node.get(i),vec_node.get(j),true);
                }   
       }
   }
        
   
    print();

    }

}
