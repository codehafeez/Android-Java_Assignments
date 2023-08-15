package com.codehafeez.example;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity2 extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Hafeez");
    }

    public void readFunction(View view){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User User = postSnapshot.getValue(User.class);
                    String v1 = User.getUseremail();
                    Toast.makeText(getApplicationContext(), "Value : "+v1, Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    String updateId = "";

    public void addFunction(View view){
        updateId = databaseReference.push().getKey();
        User user = new User();
        user.setUserid("1");
        user.setUsername("Hafeez");
        user.setUseremail("hafeez@gmail.com");
        databaseReference.child(updateId).setValue(user);
        Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
    }

    public void updateFunction(View view){
        User user = new User();
        user.setUserid("0001");
        user.setUsername("Abdul-Hafeez");
        user.setUseremail("codehafeez@gmail.com");
        databaseReference.child(updateId).setValue(user);
        Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
    }

    public void deleteFunction(View view){
        databaseReference.child(updateId).removeValue();
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
    }
}