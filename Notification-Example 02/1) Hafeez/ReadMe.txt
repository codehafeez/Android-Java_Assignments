public void function1(View view)
{
    Notification.Builder builder = new Notification.Builder(getApplicationContext());
    builder.setContentTitle("Test Message")
            .setContentText("Hello World")
            .setSmallIcon(R.drawable.bookmark);

    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(channel);
        builder.setChannelId(channel.getId());
    }

    Notification notification = builder.build();
    notificationManager.notify(1, notification);
}

// ===============================================

public void function2(View view)
{
    Notify build = Notify.build(getApplicationContext());
    build.setTitle("Abdul Hafeez - Title");
    build.setContent("Test Message Hello World");
    build.setLargeIcon(R.drawable.image1);
    build.largeCircularIcon();
    build.setPicture(R.drawable.image2);
    build.show();
}
