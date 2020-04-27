package model;

public class FriendGraph<E> extends AdjacencyMatrixBasedNonDirectedGraphData<E> {
	
	
	/*********METHODS****************************************************************/
	
	public void addContact(Vertex<E> startingVertex, Vertex<E> endingVertex)
	{
		
		addVertex(startingVertex);
		addVertex(endingVertex);
		
		
		
		if(getVertices().contains(startingVertex) && getVertices().contains(endingVertex))
		{
			int row = getVertices().indexOf(startingVertex);
			int col = getVertices().indexOf(endingVertex);
			getEdgeWeights()[row][col] += 1; 
			getEdgeWeights()[col][row] += 1; 
			
		}
		
		
		
		
	}
	

}
