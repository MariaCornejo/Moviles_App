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
public class PlaylistActivity  extends ListActivity 
{
	
    String[] pl_sad={"Give Your Heart a break-Demi Lovato",
    		"Wrecking Ball-Miley Cyrus",
    		"The Scientist-Coldplay",
    		"The one that got away-Katy Perry",
    		"Yellow-Coldplay",
    		"Just Give Me a Reason- Pink",
    		"Little Things-One Direction"
    		
    		};
    
    
    Integer[] ms_sad=
	{
    		R.raw.giveyourheartabreak,
    		R.raw.wreckingball,
    		R.raw.thescientist,
    		R.raw.theonethatgotaway,
    		R.raw.yellow,
    		R.raw.justgivemeareason,
    		R.raw.littlethings
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
        setListAdapter(new ArrayAdapter<String> (this,android.R.layout.simple_list_item_checked,pl_sad));
        
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
    		
    
    		if (mediaPlayer != null)
        	{
        		mediaPlayer.release();
        	}
            mediaPlayer = MediaPlayer.create(this,ms_sad[position]);
            mediaPlayer.setLooping(true);
            mediaPlayer.setVolume(100,100);
            mediaPlayer.start();
            Toast.makeText(this, "You have selected: "+ pl_sad[position],
        			Toast.LENGTH_SHORT).show();
    	
    	
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
