package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> tweets;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				
				tweets.add(text);
				adapter.notifyDataSetChanged();
				saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		//User u = new Author("Tim Magoo");
		
		//private String AuthorName = u.getName();
		/*
		try{
			u.setName("Othername");
		} 
		catch(IOException e){
			
			
		}
		*/
		//ArrayList<User> users = new ArrayList<User>(); 
		//ArrayList<Object> objects; 
		
		
		
		super.onStart();
		tweets = loadFromFile();
		
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private ArrayList<String> loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		Gson gson = new Gson();
		try {
			FileInputStream fis = openFileInput(FILENAME); // read the file
			InputStreamReader in = new InputStreamReader(fis);
			
			//Taken from http://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/index.html
			Type typeOfT = new TypeToken<ArrayList<String>>(){}.getType();
			tweets = gson.fromJson(in, typeOfT);
			
			fis.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;
	}
	
	private void saveInFile(String text, Date date) {
		
		Gson gson = new Gson();
		
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0); //write to the file
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(tweets, osw);
			osw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}