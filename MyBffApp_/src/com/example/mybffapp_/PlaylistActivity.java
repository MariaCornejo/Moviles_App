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
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.Button;
public class PlaylistActivity  extends ListActivity 
{
	int notificationID = 1;
    
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
            displayNotification();
            Toast.makeText(this, "You have selected: "+ pl_sad[position],
        			Toast.LENGTH_SHORT).show();
            
    	
    	
    }
    protected void displayNotification()
    {
    	Intent i = new Intent(this,NotificactionView.class);
    	i.putExtra("notificationID", notificationID);
    	PendingIntent pendingIntent = 
    			PendingIntent.getActivity(this, 0, i, 0);
    	NotificationManager nm=(NotificationManager)
    			getSystemService(NOTIFICATION_SERVICE);
    	Notification notif = new Notification(R.drawable.ic_launcher
    			,"Se añadió canción",System.currentTimeMillis());
    	CharSequence from ="MyBffApp Notificacion";
    	CharSequence message ="Se añadió una nueva canción a Favoritos";
    	notif.setLatestEventInfo(this, from, message, pendingIntent);
    	notif.vibrate = new long[]{100,250,100,500};
    	nm.notify(notificationID,notif);
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}








