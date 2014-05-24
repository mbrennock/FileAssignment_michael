package com.example.fileassignment_megabyte;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String fileName = "myFile.txt";
	String fileData = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void buttonLoad_pressed(View view){
		makeToast("Loading...");
		
		TextView tvOutput = (TextView) findViewById(R.id.tvOutput);
		fileData = loadFile(fileName);
		tvOutput.setText(fileData);

		EditText etInput = (EditText) findViewById(R.id.etInput);

		//Clear input for the next round		
		etInput.setText("");
	}
	

	public void buttonSave_pressed(View view){
		makeToast("Saving...");
		
		EditText etInput = (EditText) findViewById(R.id.etInput);
		TextView tvOutput = (TextView) findViewById(R.id.tvOutput);
		String output = tvOutput.getText() + " " + etInput.getText();
		
		saveFile(fileName, output);

		tvOutput.setText(output);

		//Clear input for the next round
		etInput.setText("");
	}
	
	
	public void buttonDelete_pressed(View view){
		makeToast("Deleting...");

		//It's kinda crude I'll admit, but it gets the job done
		saveFile(fileName, " ");


		EditText etInput = (EditText) findViewById(R.id.etInput);

		//Clear input for the next round
		etInput.setText("");		
	}
	
	
	
	//File I/O examples from the following website:
	//http://people.bridgewater.edu/~arn002/csci440/android-tutorial.htm#file
	private void saveFile(String filename, String data)
	{
		try
		{
			FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
			fos.write(data.getBytes());
			
			fos.close();
			makeToast("File successfully saved.");
		}
		catch (Exception e)
		{
			makeToast("Error saving file: " + e.getLocalizedMessage());
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
			makeToast("File successfully loaded.");
			return input;
				
		}
		catch (Exception e)
		{
			makeToast("Error loading file: " + e.getLocalizedMessage());
			return "";
		}
	}
	
	//File I/O examples from the following website:
	//http://people.bridgewater.edu/~arn002/csci440/android-tutorial.htm#file
	private void makeToast(String text)
	{
		Context context = this.getApplicationContext();
		Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		toast.show();
	}
}
