package ca.ualberta.cs.lonelytwitter;


public class TweetMessage implements Tweet 
{
	protected String text;
	protected User user; 
	
	
	public TweetMessage(User user){
		
		this.user = user; 
		
		
		
	}

	
	public void setMessage(String message){
		
		this.text = message; 
		
		
		
	}



	
	
	

}
