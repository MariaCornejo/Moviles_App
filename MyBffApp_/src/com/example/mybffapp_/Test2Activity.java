package com.example.mybffapp_;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Test2Activity extends Activity 
{
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test2_main);
	}
	public void onClick6(View view)
    {
        startActivity(new Intent("com.example.mybffapp_.PlaylistActivity"));
    }

}
