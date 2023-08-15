package com.example.abdulhafeez.xampt_hafeez;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
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

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public class SignUpActivity extends AppCompatActivity {

    String genderTxt = "Female";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText firstName, lastName, email, dateOfBirth, password, conformPasword;
    Button btnSignUp;
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firstName = (EditText) findViewById(R.id.firstNameTxt);
        lastName = (EditText) findViewById(R.id.lastNameTxt);
        email = (EditText) findViewById(R.id.emailTxt);
        password = (EditText) findViewById(R.id.passwordTxt);
        conformPasword = (EditText) findViewById(R.id.conformPasswordTxt);

        btnSignUp = (Button) findViewById(R.id.signUpBtn);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { submitForm(); }
        });

        dateOfBirth = (EditText) findViewById(R.id.dateOfBirthTxt);
        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dFragment = new DatePickerFragment();
                dFragment.show(getFragmentManager(), "Date Picker");
            }
        });
    }

    public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
    {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            dateOfBirth.setError(null); // Click to Clear (or) hide error message that show on dob_txtField

            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT,this,year,month,day);
            return  dpd;
        }

        public void onDateSet(DatePicker view, int year, int month, int day){

            // Create a Date variable/object with user chosen date
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(0);
            cal.set(year, month, day, 0, 0, 0);
            Date chosenDate = cal.getTime();

            // Format the date using style and locale
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
            String formattedDate = df.format(chosenDate);

            EditText dateOfBirthTxt = (EditText) findViewById(R.id.dateOfBirthTxt);
            dateOfBirthTxt.setText(formattedDate);
        }
        public void onCancel(DialogInterface dialog){
            // Toast.makeText(getActivity(),"Date Picker Canceled.", Toast.LENGTH_SHORT).show();
        }
    }

    private void submitForm()
    {
        if (firstName.getText().toString().length() < 1) {
            // Toast.makeText(getApplicationContext(), "Please enter first name", Toast.LENGTH_LONG).show();
            firstName.setError("Please enter first name");
            firstName.requestFocus();
        }
        else if (lastName.getText().toString().length() < 1) {
            // Toast.makeText(getApplicationContext(), "Please enter last name", Toast.LENGTH_LONG).show();
            lastName.setError("Please enter last name");
            lastName.requestFocus();
        }
        else if (email.getText().toString().length() < 1 || !email.getText().toString().matches(emailPattern)){
            // Toast.makeText(getApplicationContext(), "Please enter valid email address", Toast.LENGTH_LONG).show();
            email.setError("Please enter valid email address");
            email.requestFocus();
        }
        else if (dateOfBirth.getText().toString().length() < 1) {
            // Toast.makeText(getApplicationContext(), "Please enter date of birth", Toast.LENGTH_LONG).show();
            dateOfBirth.setError("Please enter date of birth");
            dateOfBirth.requestFocus();
        }
        else if (password.getText().toString().length() < 1) {
            // Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
            password.setError("Please enter password");
            password.requestFocus();
        }
        else if (!conformPasword.getText().toString().equals(password.getText().toString())) {
            // Toast.makeText(getApplicationContext(), "Password not match", Toast.LENGTH_LONG).show();
            conformPasword.setError("Sorry!, Password not match");
            conformPasword.requestFocus();
        }
        else { signUpDB(); }
    }

    public void signUpDB()
    {
        processDialogFunction();
        // ====================== Set IP ===========================
        String myIP = getResources().getString(R.string.programIP);
        String SIGNUP_URL = myIP+"xamta/ControllerSignUp.php";
        // ==========================================================
        final String firstNameTxt = firstName.getText().toString();
        final String lastNameTxt = lastName.getText().toString();
        final String emailTxt = email.getText().toString();
        final String dateOfBirthTxt = dateOfBirth.getText().toString();
        final String passwordTxt = password.getText().toString();
        RadioButton genderMale = (RadioButton)findViewById(R.id.male);
        if(genderMale.isChecked()){ genderTxt = "Male"; }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, SIGNUP_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray jArray = new JSONArray(response);
                    JSONObject json_obj = jArray.getJSONObject(0);
                    String lastName = json_obj.optString("lastName");

                    if (lastName.equals("emailExist")) { Toast.makeText(getApplicationContext(), "Sorry! This email is exist, please enter other email address", Toast.LENGTH_LONG).show(); }
                    else if (lastName.equals("yesDone")) { openHomeActivity(); }
                    else { Toast.makeText(getApplicationContext(), "Error: "+lastName, Toast.LENGTH_LONG).show(); }
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
                map.put("firstName",firstNameTxt);
                map.put("lastName",lastNameTxt);
                map.put("email",emailTxt);
                map.put("gender", genderTxt);
                map.put("dob",dateOfBirthTxt);
                map.put("password",passwordTxt);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void processDialogFunction(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
    }
    public void openHomeActivity(){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
}
