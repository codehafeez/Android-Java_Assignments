package com.example.abdulhafeez.notificationex;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent_o = getIntent();
        String user_name = intent_o.getStringExtra("user_name");
        Toast.makeText(getApplicationContext(), user_name, Toast.LENGTH_LONG).show();
    }
}
