package com.example.abdulhafeez.example;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityA extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void funA(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}

