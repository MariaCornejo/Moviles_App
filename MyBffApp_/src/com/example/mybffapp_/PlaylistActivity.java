package com.example.mybffapp_;

package com.example.listview;
import android.app.ListActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class PlaylistActivity  extends ListActivity 
{
	
    String[] playlist={"Thinking Out Loud-Ed Sheeran","Give Your Heart a break-Demi Lovato",
    		"Wrecking Ball-Miley Cyrus",
    		"The heart wants what it wants-Selena Gomez",
    		"The Scientist-Coldplay",
    		"The one that got away-Katy Perry",
    		"Yellow-Coldplay",
    		"Little Things-One Direction"
    		
    		};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ListView lstView=getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        setListAdapter(new ArrayAdapter<String> (this,android.R.layout.simple_list_item_checked,playlist));
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
    	Toast.makeText(this, "You have selected"+ playlist[position],
    			Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
