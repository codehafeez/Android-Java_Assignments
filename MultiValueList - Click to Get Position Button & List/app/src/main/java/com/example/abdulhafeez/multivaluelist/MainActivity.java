package com.example.abdulhafeez.multivaluelist;
import android.app.ListActivity;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
        import android.widget.*;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity
{
    ListView userList;
    UserCustomAdapter userAdapter;
    ArrayList<User> userArray = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userArray.add(new User("Mumer", "Spain", "Spain"));
        userArray.add(new User("Jon", "EW", "USA"));
        userArray.add(new User("Broom", "Span", "SWA"));
        userArray.add(new User("Lee", "Aus", "AUS"));
        userArray.add(new User("Jon", "EW", "USA"));
        userArray.add(new User("Broom", "Span", "SWA"));
        userArray.add(new User("Lee", "Aus", "AUS"));

        userAdapter = new UserCustomAdapter(MainActivity.this, R.layout.row, userArray);
        userList = (ListView) findViewById(R.id.listView);
        userList.setItemsCanFocus(false);
        userList.setAdapter(userAdapter);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, final int position, long id) {
                Toast.makeText(MainActivity.this,"List View Clicked:" + position, Toast.LENGTH_LONG).show();
            }
        });

    }
}
