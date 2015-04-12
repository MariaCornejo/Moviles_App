package com.example.mybffapp_;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	private Typeface actionFont;


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionFont = Typeface.createFromAsset(getAssets(), "fonts/actionj.ttf");
        TextView text1 = (TextView) findViewById(R.id.text01);
        text1.setTypeface(actionFont);
        text1.setText("MyBffApp");
        text1.setTextSize(40);   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick1(View view)
    {
        startActivity(new Intent("com.example.mybffapp_.LoginActivity"));
    }
}
