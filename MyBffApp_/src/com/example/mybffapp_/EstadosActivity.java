package com.example.mybffapp_;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class EstadosActivity extends Activity 
{
	private Typeface actionFont;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.estados_main);
		actionFont = Typeface.createFromAsset(getAssets(), "fonts/actionj.ttf");
        TextView text1 = (TextView) findViewById(R.id.text01);
        text1.setTypeface(actionFont);
        text1.setText("How do you feel?");
        text1.setTextSize(40);  
	}


	public void ClickSad (View view)
	{
			startActivity(new Intent("com.example.mybffapp_.PlaylistActivity"));
	}
	public void ClickHappy(View view)
	{
			startActivity(new Intent("com.example.mybffapp_.PlaylistActivityhappy"));
	}

}
