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
	private EditText  campoEmail, campoPassword;

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
    	String email,password;
    	boolean flag=true;
		campoEmail = (EditText) findViewById(R.id.txtEmail);
		campoPassword = (EditText) findViewById(R.id.txtPass);
		email=campoEmail.getText().toString();
		password=campoPassword.getText().toString();
		DBAdapter db= new DBAdapter(this);
        db.open();
        flag=db.ValidarUsuario(email,password);
        if(flag==true)
        {
        	Toast.makeText(getBaseContext(),
    				"Usuario Válido... Bienvenido!",
    				Toast.LENGTH_SHORT).show();      	
            db.close();
        	startActivity(new Intent("com.example.mybffapp_.Test1Activity"));
        }
        else
        {
        	Toast.makeText(getBaseContext(),
    				"Usuario o Password Incorrectos!",
    				Toast.LENGTH_SHORT).show();  
            db.close();
        	startActivity(new Intent("com.example.mybffapp_.LoginActivity"));

        }
		
	}
	public void onClick3(View view)
	{
			startActivity(new Intent("com.example.mybffapp_.RegistroActivity"));
	}

    
}




