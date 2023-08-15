package com.codehafeez.listview_adapter;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    String countryList[] = { "China", "Bahrain", "KSA", "Pakistan", "UAE" };
    int flags[] = { R.drawable.china, R.drawable.bahrain, R.drawable.ksa, R.drawable.pakistan, R.drawable.uae };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);


        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), countryList[position]+" = Position : "+position, Toast.LENGTH_LONG).show();
            }
        });
    }
}