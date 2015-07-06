package com.example.mybffapp_;



import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
public class NotificactionView extends Activity 
{
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        NotificationManager nm = (NotificationManager)
        		getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(getIntent().getExtras().getInt("notificationID"));
        
    }

}
