package ca.ualberta.cs.lonelytwitter;


public class Viewer extends user
{

	public void setName(String name) throws IOException{
		if (name.length() > 8){
			
			throw new IOException("Too long");	
			
		}
		
		this.name = name;
		
	}
	
	
}
