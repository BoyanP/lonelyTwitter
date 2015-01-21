package ca.ualberta.cs.lonelytwitter;


public class Retweet extends TweetMessage implements Tweet
{

	
	public Retweet(User user)
	{

		super(user);
		// TODO Auto-generated constructor stub
	}

	protected String getMessage(String Retweeted){
		
		return Retweeted;
		
		
		
	}
	
	
	
	
	
}
