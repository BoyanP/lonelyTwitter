package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;




public class Author extends User implements Userlike
{
	public Author(String string) throws IOException{
		
		super(string);
		
		
	}
	
	public void setName(String name){
		
	this.name = name;
		
		
	}
	
	
	
	
	
}
