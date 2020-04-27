package model;

import java.util.List;
import java.util.ArrayList;

public class AdjacencyMatrixBasedNonDirectedGraphData<E> implements NonDirectedGraphDataInterface<E>
{
/**Class Variables***************************************************************/
	private List<Vertex<E>> vertices = null;
	private int[][] edgeWeights = null;
	
/*******Getters and Setters**************************************************************************/
	
	public List<Vertex<E>> getVertices()
	{
		
		if(vertices == null)
		{
			 vertices = new ArrayList<Vertex<E>>(); 
		}
		
		return vertices; 
		
	}
	
	
	public int[][] getEdgeWeights()
	{
		if(edgeWeights == null)
		{
			edgeWeights = new int[0][0]; 
		}
			
		return edgeWeights;
	}
	
	public void setEdgeWeights(int[][] edgeWeights)
	{
		this.edgeWeights = edgeWeights; 
	}

	
	/******Methods**************************************************************/
	
	private int[][] removeRowColArray(int[][] startingArray, int skipRow, int skipCol)
	{
		int newSize = startingArray.length -1; 
		int[][] newArray = new int [newSize][newSize];
		int newRow = 0; 
		int newCol = 0; 
		
		for(int row = 0; row < newArray.length; row++) 
		{
			for(int col = 0; col < newArray.length; col++)
			{
				if(row >= skipRow)
				{
					newRow = row +1;
				}
				
				else
				{
					newRow = row; 
				}
				
				if(col >= skipCol)
				{
					newCol = col +1; 
				}
				
				else
				{
					newCol = col;
				}
				
				newArray[row][col] = startingArray[newRow][newCol];
				
			}
		}
		
		return newArray; 
	}
	
	
	
	@Override
	public void addVertex(Vertex<E> v) {

		getVertices().add(v);
		
		int[][] newEdgeWeights = new int[getVertices().size()][getVertices().size()]; // define a new 2 dimensional array that is one size larger than the current one
		
		for(int row = 0; row < newEdgeWeights.length; row++)
		{
			for(int col = 0; col < newEdgeWeights.length; col++)
			{
				if(row < getEdgeWeights().length && col < getEdgeWeights().length)
				{
					newEdgeWeights[row][col] = getEdgeWeights()[row][col]; 
				}
				
				else 
				{
					newEdgeWeights[row][col] = 0; 
				}
			}
			
		}
		
		setEdgeWeights(newEdgeWeights);
		
	}

	@Override
	public void removeVertex(Vertex<E> v) {
		
		int index = getVertices().indexOf(v);
		
		if(index != -1)
		{
			int[][] newEdgeWeights = removeRowColArray(getEdgeWeights(), index, index);
			setEdgeWeights(newEdgeWeights);
			getVertices().remove(index); 
		}
		
		
		
	}

	@Override
	public void addEdge(Vertex<E> startingVertex, Vertex<E> endingVertex, int weight) {
		
		if(getVertices().contains(startingVertex) && getVertices().contains(endingVertex))
		{
			int row = getVertices().indexOf(startingVertex);
			int col = getVertices().indexOf(endingVertex);
			getEdgeWeights()[row][col] = weight; 
			getEdgeWeights()[col][row] = weight; 
			
		}
		
	}

	@Override
	public void removeEdge(Vertex<E> startingVertex, Vertex<E> endingVertex) {
		
		if(getVertices().contains(startingVertex) && getVertices().contains(endingVertex))
		{
			int row = getVertices().indexOf(startingVertex);
			int col = getVertices().indexOf(endingVertex);
			getEdgeWeights()[row][col] = 0; 
			getEdgeWeights()[col][row] = 0; 
		}
		
		
	}

	@Override
	public boolean hasEdge(Vertex<E> startingVertex, Vertex<E> endingVertex) {
		boolean hasEdge = false; 
		
		if(getVertices().contains(startingVertex) && getVertices().contains(endingVertex))
		{
			int row = getVertices().indexOf(startingVertex);
			int col = getVertices().indexOf(endingVertex);
			
			if(getEdgeWeights()[row][col] != 0)
			{
				hasEdge = true; 
			}
			
		}
		
		return hasEdge;
	}
	
	
	
	//@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("The graph has ");
		buf.append(getVertices().size());
		buf.append(" vertices:\n");
		
		for(int i=0; i < getVertices().size(); i++){
			buf.append("Vertex ");
			buf.append(i);
			buf.append(":\n");
			buf.append(getVertices().get(i).toString());
			buf.append("\n\n");
		
		}
		
		buf.append("\n");
		buf.append("Here is the adjacency matrix:\n");
		buf.append("\t");
		for(int i=0; i < getVertices().size(); i++)
		{
			
			buf.append(getVertices().get(i).getIDLabel());buf.append("\t");
		}
		
		buf.append("\n");
		
		for(int row = 0; row < getEdgeWeights().length; row++)
		{
			
			buf.append(getVertices().get(row).getIDLabel());buf.append("\t");
			
			for(int col = 0; col < getEdgeWeights().length; col++)
				{
				
					buf.append(getEdgeWeights()[row][col]);buf.append("\t");
				
				}
			
			buf.append("\n");
		}
		
		buf.append("\n");
		
		return buf.toString();
			
	}

}
