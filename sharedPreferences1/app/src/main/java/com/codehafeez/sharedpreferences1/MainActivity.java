package com.codehafeez.sharedpreferences1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveDataFunction(View v){
        sharedPreferences = getApplicationContext().getSharedPreferences("MySharedPreferences", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userId", "user1");
        editor.putString("username", "Hafeez");
        editor.commit();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void callActivityFunction(View v){
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("value1", "test1");
        intent.putExtra("value2", "test2");
        startActivity(intent);
    }
}