package com.example.abdulhafeez.myworld_hafeez;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
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
public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> spinner_country_Adapter, spinner_country_state_Adapter, spinner_country_state_city_Adapter;
    ArrayList<String> CountryIdList = new ArrayList<>();
    ArrayList<String> CountryStateIdList = new ArrayList<>();
    ArrayList<String> CountryStateCityIdList = new ArrayList<>();
    Spinner country_spinner, country_state_spinner, country_state_city_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Load_CountrySpinner_Function();

        // ==================================================================================================
        // ==================================================================================================
        // ==================================================================================================
        country_spinner = (Spinner)findViewById(R.id.country_spinner);
        country_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){ Change_CountrySpinner_Function(CountryIdList.get(position-1)); }
                // else { ((TextView) country_spinner.getSelectedView()).setTextColor(getResources().getColor(R.color.color_191_191_191)); }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        country_state_spinner = (Spinner)findViewById(R.id.country_state_spinner);
        country_state_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){ Change_CountryStateSpinner_Function(CountryStateIdList.get(position-1)); }
                // else { ((TextView) country_spinner.getSelectedView()).setTextColor(getResources().getColor(R.color.color_191_191_191)); }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        country_state_city_spinner = (Spinner)findViewById(R.id.country_state_city_spinner);
        country_state_city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Work", Toast.LENGTH_LONG).show();
                // if(position != 0){ Change_CountrySpinner_Function(CountryIdList.get(position-1)); }
                // else { ((TextView) country_spinner.getSelectedView()).setTextColor(getResources().getColor(R.color.color_191_191_191)); }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
        // ==================================================================================================
        // ==================================================================================================
        // ==================================================================================================
    }

    public void Load_CountrySpinner_Function()
    {
        String myIP = getResources().getString(R.string.programIP);
        String appURL = myIP+"ControllerCountryStateCity.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, appURL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                spinner_country_Adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_item);
                spinner_country_Adapter.add("Select Country");
                try {
                    JSONArray jArray = new JSONArray(response);
                    for(int i=0;i<jArray.length();i++){
                        JSONObject json_obj = jArray.getJSONObject(i);
                        String country_id = json_obj.getString("country_id");
                        String country_name = json_obj.getString("country_name");
                        CountryIdList.add(country_id);
                        spinner_country_Adapter.add(country_name);
                    }
                    country_spinner.setAdapter(spinner_country_Adapter);
                    country_spinner.setSelection(0);
                } catch (Exception ex) { Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show(); }
            }
        },new com.android.volley.Response.ErrorListener() { @Override public void onErrorResponse(VolleyError error) { Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG ).show(); }}){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("load_country","load_country");
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void Change_CountrySpinner_Function(final String country_id)
    {
        String myIP = getResources().getString(R.string.programIP);
        String appURL = myIP+"ControllerCountryStateCity.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, appURL, new com.android.volley.Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                spinner_country_state_Adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_item);
                spinner_country_state_Adapter.add("Select State");
                try {
                    JSONArray jArray = new JSONArray(response);
                    for(int i=0;i<jArray.length();i++){
                        JSONObject json_obj = jArray.getJSONObject(i);
                        String country_state_id = json_obj.getString("country_state_id");
                        String country_state_name = json_obj.getString("country_state_name");
                        CountryStateIdList.add(country_state_id);
                        spinner_country_state_Adapter.add(country_state_name);
                    }
                    country_state_spinner.setAdapter(spinner_country_state_Adapter);
                    country_state_spinner.setSelection(0);
                } catch (Exception ex) { Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show(); }
            }
        },new com.android.volley.Response.ErrorListener() { @Override public void onErrorResponse(VolleyError error) { Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG ).show(); }}){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("country_id",country_id);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void Change_CountryStateSpinner_Function(final String country_state_id)
    {
        String myIP = getResources().getString(R.string.programIP);
        String appURL = myIP+"ControllerCountryStateCity.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, appURL, new com.android.volley.Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                spinner_country_state_city_Adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_item);
                spinner_country_state_city_Adapter.add("Select City");
                try {
                    JSONArray jArray = new JSONArray(response);
                    for(int i=0;i<jArray.length();i++){
                        JSONObject json_obj = jArray.getJSONObject(i);
                        String country_state_city_id = json_obj.getString("country_state_city_id");
                        String country_state_city_name = json_obj.getString("country_state_city_name");
                        CountryStateCityIdList.add(country_state_city_id);
                        spinner_country_state_city_Adapter.add(country_state_city_name);
                    }
                    country_state_city_spinner.setAdapter(spinner_country_state_city_Adapter);
                    country_state_city_spinner.setSelection(0);
                } catch (Exception ex) { Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show(); }
            }
        },new com.android.volley.Response.ErrorListener() { @Override public void onErrorResponse(VolleyError error) { Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG ).show(); }}){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("state_id_country",country_state_id);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}