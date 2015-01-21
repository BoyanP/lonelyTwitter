package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class Following extends User implements Follows
{
	//User userWhoFollows = new User();
	ArrayList<User> FollowList; 
	
	
	public void setFollowList( ArrayList<User> listOfFollowers){
		
		this.FollowList = listOfFollowers;
		
	}
	
	
	public ArrayList<User> getFollowList(){
		
		
		return FollowList;
		
		
	}
	
	
	
}
