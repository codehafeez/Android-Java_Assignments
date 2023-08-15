package com.codehafeez.notification;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.application.isradeleon.notify.Notify;
public class MainActivity extends AppCompatActivity {

    // read me => https://github.com/isradeleon/Notify-Android

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void function1(View view){
        Notify build = Notify.build(getApplicationContext());
        build.setTitle("Abdul Hafeez");
        build.setContent("Test Message Hello World");
        build.setSmallIcon(R.drawable.ic_notification);
        build.setLargeIcon(R.drawable.image1);
        build.largeCircularIcon();
        build.setPicture(R.drawable.image2);
        build.setId(001);
        build.show();
    }

    public void function2(View view){
        Notify build = Notify.build(getApplicationContext());
        build.setTitle("Test Msg");
        build.setContent("Hello World");
        build.setSmallIcon(R.drawable.ic_notification);
        build.setId(001); // Update notification by id
        build.show();
    }
}