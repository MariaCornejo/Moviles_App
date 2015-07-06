package com.example.mybffapp_;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
public class PlaylistActivityhappy  extends ListActivity 
{
	
			String[] pl_happy={
    		
    		"Bang Bang Bang - A.Grande, Jessie J & Nicky Minage",
    		"Break Free - Ariana Grande",
    		"Hangover - Taio Cruz",
    		"Please don´t stop the music- Rihanna",
    		"Problem- Ariana Grande",
    		"Sing-Ed Sheeran",
    		"Shake It Off- Taylor Swift",
    		"We Can´t Stop - Miley Cyrus"

    		
    		};
    
    
			
    private ImageButton bPlay, bPause, bStop;
    MediaPlayer mediaPlayer;
    private boolean pause;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    	
        super.onCreate(savedInstanceState);
        ListView lstView=getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lstView.setTextFilterEnabled(true);
        setListAdapter(new ArrayAdapter<String> (this,android.R.layout.simple_list_item_checked,pl_happy));
        
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
    		
    
    		
            Toast.makeText(this, "You have selected: "+ pl_happy[position],
        			Toast.LENGTH_SHORT).show();
    	
    	
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
