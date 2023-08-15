package com.codehafeez.rest_api;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // https://www.geeksforgeeks.org/how-to-make-an-http-request-with-android/
        // https://www.geeksforgeeks.org/how-to-post-data-to-api-using-volley-in-android
    }

    public void readFunction(View view){
        RequestQueue volleyQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://dog.ceo/api/breeds/image/random";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,(Response.Listener<JSONObject>) response -> {
                    try {
                        String msg = response.getString("message");
                        System.out.println(msg);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },(Response.ErrorListener) error -> {
                    Toast.makeText(getApplicationContext(), "Some error occurred...", Toast.LENGTH_LONG).show();
                }
        );
        volleyQueue.add(jsonObjectRequest);
    }

    public void postFunction(View view){
        String url = "https://reqres.in/api/users";
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject respObj = new JSONObject(response);
                    String name = respObj.getString("name");
                    String job = respObj.getString("job");
                    System.out.println(name+" = "+job);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Hafeez");
                params.put("job", "Developer");
                return params;
            }
        };
        queue.add(request);
    }
}