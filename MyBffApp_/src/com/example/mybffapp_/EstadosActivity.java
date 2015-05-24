package com.example.mybffapp_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class EstadosActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.estados_main);
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
