import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TwitterListModel;
import android.test.ActivityInstrumentationTestCase2;



public class TweetListModelTests extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{

	private TwitterListModel tweets;
	
	public TweetListModelTests()
	{

		super(LonelyTwitterActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception
	{

		super.setUp();
		tweets = new TwitterListModel();
	}

	public void tweetsListsInitialised(){
		
		TwitterListModel tweets = new TwitterListModel();
		assertNotNull("Is my arraylsit not initialised?",tweets);
		
	}
	
	public void testListCount(){
		
		NormalTweetModel tweet = new NormalTweetModel("Wow what");
		tweets.addTweet(tweet);
		assertEquals("Added a tweet, counter updated?",1,tweets.getListLength());
		
		
		
		
	}
	
	
	
}
