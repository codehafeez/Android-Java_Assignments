package com.example.abdulhafeez.multivaluenew;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        getValuesFromDB_toSetProfile();
        userAdapter = new UserCustomAdapter(this, R.layout.row, userArray);
        userList = (ListView) findViewById(R.id.listView);
        userList.setAdapter(userAdapter);
    }

    public void getValuesFromDB_toSetProfile()
    {
        String myIP = getResources().getString(R.string.programIP);
        String PROFILE_URL = myIP+"xamta/ControllerSearchNewFriend.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, PROFILE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jArray = new JSONArray(response);
                    for(int i=0;i<jArray.length();i++) {
                        JSONObject json_obj = jArray.getJSONObject(i);
                        String firstName = json_obj.optString("firstName");
                        String lastName = json_obj.optString("lastName");
                        String profileImage = json_obj.optString("profileImage");
                        String myIP = getResources().getString(R.string.programIP);
                        String dbImageUrl = myIP+"xamta/"+profileImage;

                        // Name, Image, ButtonRequest
                        userArray.add(new User(firstName+" "+lastName, dbImageUrl, "BtnReq"));
                    }
                } catch (Exception ex) { Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show(); }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) { Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG ).show(); }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("searchNewFriend","searchNewFriend");
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
