package com.codehafeez.networkstate1;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        adapter.add("Abdul");
        adapter.add("Hafeez");
        adapter.add("Usman");
        adapter.add("Ali");
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item1 = parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Spinner : "+item1, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        Switch mySwitch = (Switch) findViewById(R.id.mySwitch);
        mySwitch.setChecked(true); // Switch is ON Status
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if(isChecked){ System.out.println("Switch is currently ON"); }
                else{  System.out.println("Switch is currently OFF"); }
            }
        });
    }

    public void toastMsgFunction(View view){
      Toast.makeText(getBaseContext(), "Hafeez Toast Example", Toast.LENGTH_SHORT).show();
//        Toast toastEx = Toast.makeText(getBaseContext(), "Hafeez Toast Example", Toast.LENGTH_SHORT);
//        toastEx.setGravity(Gravity.TOP,0,0);
////        toastEx.SetGravity(Gravity.CENTER, 0,0);
////        toastEx.SetGravity(Gravity.BOTTOM, 0,0);
////        toastEx.SetGravity(Gravity.LEFT, 0,0);
////        toastEx.SetGravity(Gravity.RIGHT, 0,0);
//        toastEx.show();
    }

    public void snackBarMsgFunction(View view){
         Snackbar.make(findViewById(R.id.my_layout), "Message is deleted", Snackbar.LENGTH_LONG).show();

//        Snackbar snackbar = Snackbar
//            .make(findViewById(R.id.my_layout), "Try again!", Snackbar.LENGTH_LONG)
//            .setAction("RETRY", new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
//                }
//            });
//        snackbar.setActionTextColor(Color.RED);
//        snackbar.show();
    }

    public void funCheckValues(View view){
        ArrayList<String> mylist = new ArrayList<String>();
        CheckBox cb1 = (CheckBox)findViewById(R.id.apple);
        CheckBox cb2 = (CheckBox)findViewById(R.id.bananaa);
        if(cb1.isChecked() == true){ mylist.add("Apple"); }
        if(cb2.isChecked() == true){ mylist.add("Bananaa"); }
        Toast.makeText(getApplicationContext(), "Selected Itoms : "+mylist, Toast.LENGTH_LONG).show();
    }

    public void readRadioButtonFunction(View view){
        ArrayList<String> mylist = new ArrayList<String>();
        RadioButton rb1 = (RadioButton)findViewById(R.id.apple1);
        RadioButton rb2 = (RadioButton)findViewById(R.id.bananaa1);
        if(rb1.isChecked() == true){ mylist.add("Apple"); }
        if(rb2.isChecked() == true){ mylist.add("Bananaa"); }
        Toast.makeText(getApplicationContext(), "Radio Button : "+mylist, Toast.LENGTH_LONG).show();
    }

    public void showAlertDialogFunction(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());
        alertDialogBuilder.setTitle("Your Title");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void showProcessDialogFunction(View view){
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading Please Wait...");
        progressDialog.show();
        new android.os.Handler().postDelayed(new Runnable(){
            public void run() {
                progressDialog.dismiss();
            }
        }, 2000);
    }
}