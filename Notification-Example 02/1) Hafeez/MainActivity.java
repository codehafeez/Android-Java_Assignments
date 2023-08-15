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
        Notify.build(getApplicationContext())
            .setTitle("Abdul Hafeez - Title")
            .setContent("Test Message Hello World")
            .setLargeIcon(R.drawable.image1)
            .largeCircularIcon()
            .setPicture(R.drawable.image2)
            .show();
    }
}