package com.codehafeez.notification;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void function1(View view){
        int notificationID = 001;
        String title = "Abdul Hafeez";
        String msg = "Test Message Hello World";

        // Notification
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        builder.setContentTitle(title);
        builder.setContentText(msg);
        builder.setSmallIcon(R.drawable.ic_bell);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channel.getId());
        }

        Notification notification = builder.build();
        notificationManager.notify(notificationID, notification);
    }

    public void function2(View view){
        int notificationID = 002;
        String title = "Abdul Hafeez";
        String msg = "Test Message Hello World";

        // Notification Click
        Intent intent = new Intent(this, NotifyActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle extras = new Bundle();
        extras.putString(NotifyActivity.notify_title, title);
        extras.putString(NotifyActivity.notify_content, msg);
        intent.putExtras(extras);
        intent.setAction(Intent.ACTION_VIEW);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), notificationID, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        // Notification
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        builder.setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(R.drawable.ic_bell)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channel.getId());
        }

        Notification notification = builder.build();
        notificationManager.notify(notificationID, notification);
    }

    public void function3(View view){
        int notificationID = 002;
        String title = "Test";
        String msg = "Hello World";

        // Notification Click
        Intent intent = new Intent(this, NotifyActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle extras = new Bundle();
        extras.putString(NotifyActivity.notify_title, title);
        extras.putString(NotifyActivity.notify_content, msg);
        intent.putExtras(extras);
        intent.setAction(Intent.ACTION_VIEW);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), notificationID, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        // Notification
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        builder.setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(R.drawable.ic_bell)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channel.getId());
        }

        Notification notification = builder.build();
        notificationManager.notify(notificationID, notification);
    }
}