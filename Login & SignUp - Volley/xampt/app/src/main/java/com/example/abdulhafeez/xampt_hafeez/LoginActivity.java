package com.example.abdulhafeez.xampt_hafeez;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;
public class LoginActivity extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText emailTxt, passwordTxt;
    Button signInBtn;
    TextView signUpBtn;
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTxt = (EditText) findViewById(R.id.emailTxt);
        passwordTxt = (EditText) findViewById(R.id.passwordTxt);

        signInBtn = (Button) findViewById(R.id.signInBtn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { submitLoginForm(); }
        });

        signUpBtn = (TextView) findViewById(R.id.signUpBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openSignUpActivity(); }
        });
    }

    public void submitLoginForm()
    {
        if (emailTxt.getText().toString().length() < 1 || !emailTxt.getText().toString().matches(emailPattern)){
            // Toast.makeText(getApplicationContext(), "Please enter valid email address", Toast.LENGTH_LONG).show();
            emailTxt.setError("Please enter valid email address");
            emailTxt.requestFocus();
        }
        else if (passwordTxt.getText().toString().length() < 1) {
            // Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
            passwordTxt.setError("Please enter password");
            passwordTxt.requestFocus();
        }
        else { loginDB(); }
    }

    public void loginDB()
    {
        processDialogFunction();
        // ====================== Set IP ===========================
        String myIP = getResources().getString(R.string.programIP);
        String LOGIN_URL = myIP+"xamta/ControllerLogin.php";
        // ==========================================================
        final String email = emailTxt.getText().toString();
        final String password = passwordTxt.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jArray = new JSONArray(response);
                    JSONObject json_obj = jArray.getJSONObject(0);
                    String lastName = json_obj.optString("lastName");

                    if (lastName.equals("LoginError")) { Toast.makeText(getApplicationContext(), "Sorry!, Email or password is incorrect..!", Toast.LENGTH_LONG).show(); }
                    else
                    {
                        openHomeActivity();
                        Toast.makeText(getApplicationContext(), "YesName: "+lastName, Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) { Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show(); }
                progressDialog.dismiss();
            }

        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG ).show(); }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("email",email);
                map.put("password",password);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void openSignUpActivity(){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
    public void openHomeActivity(){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
    public void processDialogFunction(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do you want to Exit..?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { }
        });
        builder.show();
    }
}
