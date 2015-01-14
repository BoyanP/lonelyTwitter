package ca.ualberta.cs.lonelytwitter;


public class Following extends User implements Follows
{
	User userWhoFollows = new User();
	ArrayList<User> FollowList = new ArrayList<User>; 
	
	
	public void setFollowList( ArrayList<User> listOfFollowers){
		
		this.FollowList = listOfFollowers;
		
	}
	
	
	public ArrayList<User> getFollowList(){
		
		
		return FollowList;
		
		
	}
	
	
	
}
