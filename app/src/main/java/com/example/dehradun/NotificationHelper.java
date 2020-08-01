package com.example.dehradun;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Random;

public class NotificationHelper<button> extends ContextWrapper {

    private static final String TAG = "NotificationHelper";

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels();
        }
    }

    private String CHANNEL_NAME = "High priority channel";
    private String CHANNEL_ID = "com.example.notifications" + CHANNEL_NAME;

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setDescription("this is the description of the channel.");
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(notificationChannel);
    }

    public void sendHighPriorityNotification(String title, String body, Class activityName) {

        Intent intent = new Intent(NotificationHelper.this, activityName);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 267, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Traffic")
                .setContentText("Is there a traffic")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setStyle(new NotificationCompat.BigTextStyle().setSummaryText("summary").setBigContentTitle(title).bigText(body))
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_launcher_foreground,"Yes",pendingIntent)
                .addAction(R.drawable.ic_launcher_foreground,"No",pendingIntent)
                .setAutoCancel(true)
                .build();


        NotificationManagerCompat.from(this).notify(new Random().nextInt(), notification);

        Intent intent1 = new Intent (NotificationHelper.this,Mainpage.class);
        intent1.putExtra("Yes",true);
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(NotificationHelper.this,0,intent1,PendingIntent.FLAG_ONE_SHOT);
        if (intent1.equals(true)) {
            Toast.makeText(getBaseContext(), "Thanks for Response", Toast.LENGTH_SHORT).show();
        }
        Intent intent2 = new Intent (NotificationHelper.this,Mainpage.class);
        intent2.putExtra("No",false);
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(NotificationHelper.this,1,intent2,PendingIntent.FLAG_ONE_SHOT);
        if (intent2.equals(true)) {
            Toast.makeText(getBaseContext(),"Thanks for Response",Toast.LENGTH_SHORT).show();
        }
    }
}