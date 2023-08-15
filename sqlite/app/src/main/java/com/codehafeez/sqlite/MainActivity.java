package com.codehafeez.sqlite;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;
public class MainActivity extends AppCompatActivity {

    // https://www.javatpoint.com/android-sqlite-tutorial
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);
    }

    public void addFunction(View view){
        Log.d("Add", "Add Contact");
        db.addContact(new Contact("Hafeez", "123123132")); // auto generate id
    }

    public void updateFunction(View view){
        db.updateContact(new Contact(1, "Hafeez", "123123132"));
        Log.d("Update", "Update Contact 01");
    }

    public void deleteFunction(View view){
        db.deleteContactById(1);
        Log.d("Delete", "Delete Contact 01");
    }

    public void readAllFunction(View view){
        Log.d("Read", "Read Data All");
        List<Contact> contacts = db.getAllContacts();
        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            Log.d("Read Data All => ", log);
        }
    }

    public void readOneFunction(View view){
        Contact contacts = (Contact) db.getContact(1);
        String log = "Id: " + contacts.getID() + " ,Name: " + contacts.getName() + " ,Phone: " + contacts.getPhoneNumber();
        Log.d("Read Data One => ", log);
    }

    public void countRecord(View view){
         int totalRecords = db.getContactsCount();
         Log.d("Total => ", "Total Records "+totalRecords);
    }

    public void getNamesIndex1(View view){
        List<String> labels = db.getNames();
        Log.d("getNames => ", "getNames : "+labels);
    }

}