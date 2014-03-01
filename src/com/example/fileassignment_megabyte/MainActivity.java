package com.example.fileassignment_megabyte;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//btnReadText: WIP
	
	
	//btnAppendText: WIP
	
	
	//btnReplaceText: WIP
	
	
	//File I/O examples from the following website:
	//http://people.bridgewater.edu/~arn002/csci440/android-tutorial.htm#file
	private void saveFile(String filename, String data)
	{
		try
		{
			FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
			fos.write(data.getBytes());
			fos.close();
			toast("File successfully saved.");
		}
		catch (Exception e)
		{
			toast("Error saving file: " + e.getLocalizedMessage());
		}
	}

	//File I/O examples from the following website:
	//http://people.bridgewater.edu/~arn002/csci440/android-tutorial.htm#file
	private String loadFile(String filename)
	{
		try
		{
			FileInputStream fis = openFileInput(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			String input = "";
			
			while ( (line = reader.readLine() ) != null)
				input += line;
				
			reader.close();
			fis.close();
			toast("File successfully loaded.");
			return input;
				
		}
		catch (Exception e)
		{
			toast("Error loading file: " + e.getLocalizedMessage());
			return "";
		}
	}
	
	//File I/O examples from the following website:
	//http://people.bridgewater.edu/~arn002/csci440/android-tutorial.htm#file
	private void toast(String text)
	{
		Context context = getApplicationContext();
		Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
		toast.show();
	}
}
