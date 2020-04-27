package model;

/**
 * This interface defines methods to add and remove vertices and edges and 
 * indicates whether or not there exists an edge going from a starting vertex to
 * an ending vertex.  Since this method may be used on directed as well as
 * non-directed graphs, the order of the vertexes passed in to the hasEdge method
 * is important.
 * @author tpolk
 *
 * @param <E>
 */
public interface NonDirectedGraphDataInterface<E> {
	public void addVertex(Vertex<E> v);
	public void removeVertex(Vertex<E> v);
	public void addEdge(Vertex<E> startingVertex, Vertex<E> endingVertex, int weight);
	public void removeEdge(Vertex<E> startingVertex, Vertex<E> endingVertex);
	public boolean hasEdge(Vertex<E> startingVertex, Vertex<E> endingVertex);
}
