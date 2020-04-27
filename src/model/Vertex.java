package model;

public class Vertex<E> {
		
	
/*******Class Variables***************************************************/
	private String idLabel = null;
	private E element = null; 
	
	
/*******Getters and Setters****************************************************************/	
	
	public String getIDLabel()
	{
		return idLabel;
	}
	
	
	public E getElement()
	{
		return element; 
	}
	
	
	
/****Constructor**************************************************************/	
	
public Vertex(String idLabel, E element)	
{
	this.idLabel = idLabel;
	this.element = element; 
}
	
	
/*****Methods**********************************************************/	
	
	public String toString()
	{
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(getIDLabel());
		buffer.append(" - ");
		buffer.append(getElement().toString());
		buffer.append("\n");
		
		return buffer.toString(); 
		
	}
	
}


