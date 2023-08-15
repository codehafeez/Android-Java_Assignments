package com.codehafeez.service;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startFunction(View view){
        startService(new Intent( this, NewService.class ) );
    }

    public void stopFunction(View view){
        stopService(new Intent( this, NewService.class ) );
    }
}