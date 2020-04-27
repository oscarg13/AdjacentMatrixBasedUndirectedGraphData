package model;

public class Friend {
	
	
	/*********CLASS VARIABLES****************************************************************/
	
	private String firstName = null;
	private String lastName  = null;
	
	/*********GETTERS AND SETTERS****************************************************************/
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}

	
	public String getInitials()
	{
		String initials = null;
		
		initials = getFirstName().substring(0, 1) + getLastName().substring(0,1);
		
		return initials; 
	}
	
	
	/*********CONSTRUCTORS****************************************************************/
	
	public Friend(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	/*********METHODS****************************************************************/
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(firstName);
		buf.append(" ");
		buf.append(lastName);
		
		return buf.toString();
	}
	
}
