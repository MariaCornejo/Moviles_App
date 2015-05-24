package com.example.mybffapp_;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.database.Cursor;
public class Test1Activity extends Activity 
{


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		DBAdapter db= new DBAdapter(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test1_main);
		db.open();
        Cursor c= db.getAllContacts();
        if(c.moveToFirst())
        {
        	do
        	{
        		DisplayContact(c);
        	}while(c.moveToNext());
        }
        db.close();
        
	}

	
	public void DisplayContact(Cursor c)
    {
    	Toast.makeText(this, 
    			"DNI:"+c.getString(0)+"\n"+
    			"Name:"+c.getString(1)+"\n"+
    			"Email:"+c.getString(2),Toast.LENGTH_LONG).show();
    }

	public void miClick(View view)
	{
			startActivity(new Intent("com.example.mybffapp_.Test2Activity"));
	}

}
