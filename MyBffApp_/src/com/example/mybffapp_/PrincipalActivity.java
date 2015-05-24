package com.example.mybffapp_;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class PrincipalActivity extends Activity 
{
	private Typeface actionFont;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal_main);
		actionFont = Typeface.createFromAsset(getAssets(), "fonts/actionj.ttf");
        TextView text1 = (TextView) findViewById(R.id.text01);
        text1.setTypeface(actionFont);
        text1.setText("MyBffApp");
        text1.setTextSize(40);  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void ClickMusic (View view)
	{
			startActivity(new Intent("com.example.mybffapp_.EstadosActivity"));
	}
	public void ClickRemember(View view)
	{
			startActivity(new Intent("com.example.mybffapp_.RememberActivity"));
	}
	public void Recomendar(View view)
	{
			startActivity(new Intent("com.example.mybffapp_.EmailsActivity"));
	}

}
