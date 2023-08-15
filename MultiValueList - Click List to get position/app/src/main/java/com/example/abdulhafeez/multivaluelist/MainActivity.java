package com.example.abdulhafeez.multivaluelist;
import android.app.ListActivity;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.*;
public class MainActivity extends AppCompatActivity
{
    String[] players = {"Ali", "Usman", "Fazal", "Hafeez", "Jabbar"};
    int[] images = {R.drawable.home, R.drawable.home, R.drawable.home, R.drawable.home, R.drawable.home};

    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView)findViewById(R.id.android_list);
        CustomAdapter adapter = new CustomAdapter(this, players, images);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Toast.makeText(getApplicationContext(), position+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

