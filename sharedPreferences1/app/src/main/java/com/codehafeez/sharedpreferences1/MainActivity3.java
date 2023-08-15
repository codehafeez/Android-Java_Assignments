package com.codehafeez.sharedpreferences1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void goBackFunction(View v){
        finish();
    }

    public void showDataFunction(View v){
        Intent intent = getIntent();
        String v1 = intent.getStringExtra("value1");
        String v2 = intent.getStringExtra("value2");
        Toast.makeText(getApplicationContext(), v1+" - "+v2, Toast.LENGTH_LONG).show();
    }
}