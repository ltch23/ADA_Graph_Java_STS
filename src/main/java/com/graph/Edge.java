package com.graph;

public class Edge {

	public boolean e_dir;
	public int e_data;
	public Node[] e_node= new Node[2];

	public Edge(int e_data, Node e_nodea, Node e_nodeb ,boolean e_dir){
		this.e_dir=e_dir;
		this.e_data=e_data;
		this.e_node[0]=e_nodea;
		this.e_node[1]=e_nodeb;
	}
}
