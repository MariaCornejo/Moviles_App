package com.example.mybffapp_;


import java.io.File;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RememberActivity extends Activity 
{

		EditText textBox;
		static final int READ_BLOCK_SIZE=100;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.remember_main);
	        textBox = (EditText) findViewById(R.id.txtText1);
	        
	    }


	    public void onClickSave (View view)
	    {

	    	String str = textBox.getText().toString();
	    	try
	    	{
	    		File sdCard = Environment.getExternalStorageDirectory();
	    		File directory = new File (sdCard.getAbsolutePath()+
	    				"/MyFiles");
	    		
	    		directory.mkdirs();
	    		File file = new File (directory,"textfile.txt");
	    		FileOutputStream fOut = new FileOutputStream(file);
	    		
	    		/*
	    		FileOutputStream fOut=
	    				openFileOutput("textfile.txt",
	    						MODE_WORLD_READABLE);*/
	    		OutputStreamWriter osw=new
	    				OutputStreamWriter (fOut);
	    		
	    		osw.write(str);
	    		osw.flush();
	    		osw.close();
	    		Toast.makeText(getBaseContext(),
	    				"File saved successfully!",
	    				Toast.LENGTH_SHORT).show();
	    		
	    		textBox.setText("");
	    		
	    	}
	    	catch(IOException ioe)
	    	{

	    		ioe.printStackTrace();
	    	}
	    	
	    
	    }
	    
	    
	    public void onClickLoad(View view)
	    {

	    	try
	    	{
	    		File sdCard = Environment.getExternalStorageDirectory();
	    		File directory = new File (sdCard.getAbsolutePath()+
	    				"/MyFiles");
	    		
	    		
	    		File file = new File (directory,"textfile.txt");
	    		FileInputStream fIn = new FileInputStream(file);
	    		InputStreamReader isr = new InputStreamReader(fIn);
	    		
	    		/*
	    		FileInputStream fIn=
	    				openFileInput("textfile.txt");
	    		InputStreamReader isr = new
	    				InputStreamReader(fIn);
	    		*/
	    		char[] inputBuffer = new char[READ_BLOCK_SIZE];
	    		String s="";
	    		
	    		int charRead;
	    		while((charRead = isr.read(inputBuffer))>0)
	    		{
	    			String readString =
	    					String.copyValueOf(inputBuffer,0,charRead);
	    			s+=readString;
	    			
	    			inputBuffer = new char [READ_BLOCK_SIZE];
	    			
	    		}
	    		
	    		textBox.setText(s);
	    		
	    		Toast.makeText(getBaseContext(), 
	    				"File loaded successfully!",
	    				Toast.LENGTH_SHORT).show();
	    		
	    	}
	    	
	    	catch(IOException ioe)
	    	{

	    		ioe.printStackTrace();
	    	}
	    
	    }
	    
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) 
	    {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    
	}












