package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.lonelytwitter.R;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.*;





public class intentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity>
{

	public intentReaderActivityTest()
	{

		super(IntentReaderActivity.class);
	}

	protected void setUp() throws Exception
	{

		super.setUp();
	
	}

	public void testSendText(){
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text,IntentReaderActivity.NORMAL);
		assertEquals("Is the activity getting my text?",text,activity.getText());
		
	}
	
	public void testDefaultText(){
		
		String default_message = "I am so default.";
		IntentReaderActivity activity = startWithText("",IntentReaderActivity.NORMAL);
		assertEquals("Do you even default message?", default_message,activity.getText().toString());
		
		
		
	}
	
	public void testTextViewIsVisible(){
		
		IntentReaderActivity activity = startWithText("pops",IntentReaderActivity.NORMAL);
		TextView da_view = ((TextView) activity.findViewById(R.id.intentText) );
		//IntentReaderActivity bacon = new IntentReaderActivity();
		View originView = activity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(originView,da_view);
		
	}
	
	
	public void testReverseText(){
		
		String text_to_test = "What is cooking";
		IntentReaderActivity activity = startWithText(text_to_test,IntentReaderActivity.REVERSE);
		assertEquals("Did you reverse it?","gnikooc si tahW",activity.getText().toString());
		
	}
	
	public void testDoubleText(){
		
		String text = "NO.";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.DOUBLE);
		assertEquals("correct?",text+text, activity.getText());
	}
	
	public void testDisplayTest(){
		
		IntentReaderActivity activity = startWithText("Wow.",IntentReaderActivity.NORMAL);
		TextView textview = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("displays correct text?","Wow.",textview.getText());
		
	}
	
	
	private IntentReaderActivity startWithText(String text, int transform_code){
		
		Intent intent = new Intent();
		
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY,transform_code);
		setActivityIntent(intent);		
		
		return (IntentReaderActivity) getActivity();
	}
	

	
}
