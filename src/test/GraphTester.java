package test;

import model.AdjacencyMatrixBasedNonDirectedGraphData;
import model.Friend;
import model.FriendGraph;
import model.Vertex;

public class GraphTester {

	public static void main(String[] args) {
		AdjacencyMatrixBasedNonDirectedGraphData<String> graph = new AdjacencyMatrixBasedNonDirectedGraphData<String>();
		Vertex<String> tom = new Vertex<String>("Tom", "Tom");
		Vertex<String> fred = new Vertex<String>("Fred", "Fred");
		Vertex<String> sue = new Vertex<String>("Sue", "Sue");
		Vertex<String> ben = new Vertex<String>("Ben", "Ben");
		Vertex<String> amy = new Vertex<String>("Amy", "Amy");
		
		graph.addVertex(tom);
		graph.addVertex(fred);
		graph.addVertex(sue);
		graph.addVertex(ben);
		graph.addVertex(amy);
		
		graph.addEdge(tom,  amy, 1);
		graph.addEdge(tom,  fred, 1);
		graph.addEdge(tom,  ben, 1);
		graph.addEdge(amy,  ben, 1);
		graph.addEdge(amy,  sue, 1);
		graph.addEdge(fred,  sue, 1);
		graph.addEdge(sue,  ben, 1);
		
		System.out.println(graph);
		graph.removeEdge(tom,  fred);
		System.out.println(graph);
		System.out.println("Is there an edge between Sue and Amy? ");
		System.out.println(graph.hasEdge(sue,  amy));
		
		System.out.println();
		System.out.println("Removing edge between Sue and Amy.");
		graph.removeEdge(sue,  amy);
		System.out.println();
		System.out.println("Is there an edge between Sue and Amy? ");
		System.out.println(graph.hasEdge(sue,  amy));
		
		
		Vertex<Friend> kaite = new Vertex<Friend>("KW", new Friend("Kaite", "White"));
		Vertex<Friend> john = new Vertex<Friend>("JB", new Friend("John", "Brown"));
		Vertex<Friend> mario = new Vertex<Friend>("ML", new Friend("Mario", "Lopez"));
		Vertex<Friend> freddy = new Vertex<Friend>("FK", new Friend("Freddie", "Krueger"));
		Vertex<Friend> susan = new Vertex<Friend>("SS", new Friend("Susan", "Smith"));
		Vertex<Friend> myself = new Vertex<Friend>("OG", new Friend("Oscar", "Gomez"));
		
		FriendGraph<Friend> friendGraph = new FriendGraph<Friend>();
		
		System.out.println("Texting within the past 48 hours");
		
		friendGraph.addContact(myself, kaite);
		friendGraph.addContact(freddy, myself);
		friendGraph.addContact(myself, john);
		friendGraph.addContact(susan, myself);
		friendGraph.addContact(myself, mario);

		friendGraph.addContact(myself, kaite);
		friendGraph.addContact(freddy, myself);
		friendGraph.addContact(myself, john);
		friendGraph.addContact(susan, myself);
		friendGraph.addContact(myself, mario);
		
		System.out.println(friendGraph);
		
	}

}
