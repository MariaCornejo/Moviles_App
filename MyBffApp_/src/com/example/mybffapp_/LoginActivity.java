package com.example.mybffapp_;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class LoginActivity extends Activity 
{
	
	private EditText et1;
	String[] emails={"pespinozagomez@gmail.com",
			"malucornejo.96@gmail.com",
			"pmantillacardenas@gmail.com",
			"luismontalvo@gmail.com" +
			"silvanaespinoza@gmail.com"
			
			};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_dropdown_item_1line,emails);
        AutoCompleteTextView textView = (AutoCompleteTextView)
        		findViewById(R.id.txtEmail);
        textView.setThreshold(3);
        textView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onClick2(View view)
	{
			startActivity(new Intent("com.example.mybffapp_.Test1Activity"));
	}
	public void onClick3(View view)
	{
			startActivity(new Intent("com.example.mybffapp_.RegistroActivity"));
	}

    
}




