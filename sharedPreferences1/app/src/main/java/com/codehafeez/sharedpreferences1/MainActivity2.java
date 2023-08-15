package com.codehafeez.sharedpreferences1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class MainActivity2 extends AppCompatActivity {

    SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void showDataFunction(View v){
        sharedPreferences = getApplicationContext().getSharedPreferences("MySharedPreferences", 0);
        String uId = sharedPreferences.getString("userId", null);
        String uName = sharedPreferences.getString("username", null);
        Toast.makeText(getApplicationContext(),uId+" - "+uName,Toast.LENGTH_LONG).show();
    }

    public void clearDataFunction(View v){
        sharedPreferences = getApplicationContext().getSharedPreferences("MySharedPreferences", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().commit();
        Toast.makeText(getApplicationContext(),"Clear Data",Toast.LENGTH_LONG).show();
    }
}