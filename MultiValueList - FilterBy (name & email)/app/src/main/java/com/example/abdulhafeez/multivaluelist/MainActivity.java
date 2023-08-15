package com.example.abdulhafeez.multivaluelist;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;
public class MainActivity extends Activity
{
    String[] names = {"Ali", "Usman", "Fazal", "Hafeez", "Jabbar"};
    String[] emails = {"ali@gmail.com", "usman@gmail.com", "fazal@gmail.com", "hafeez@gmail.com", "jabbar@gmail.com"};
    int[] images = {R.drawable.home, R.drawable.home, R.drawable.home, R.drawable.home, R.drawable.home};

    ListView listView1;
    SearchView searchView1;
    ArrayList<Player> playersArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.android_list);
        searchView1 = (SearchView) findViewById(R.id.searchView1);
        Adapter adapter = new Adapter(this, getPlayers());
        listView1.setAdapter(adapter);

        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String s) { return false; }
            @Override public boolean onQueryTextChange(String searchTxt) { searchFunction(searchTxt.toString().toUpperCase()); return false; }
        });
    }

    public ArrayList<Player> getPlayers()
    {
        Player p;
        for(int i=0; i<names.length; i++){
            p = new Player(names[i], emails[i], images[i]);
            playersArrayList.add(p);
        }
        return playersArrayList;
    }

    public void searchFunction(String searchTxt)
    {
        ArrayList<Player> filterList = new ArrayList<>();
        for(int i=0; i<playersArrayList.size(); i++)
        {
            if(playersArrayList.get(i).getName().toUpperCase().contains(searchTxt))
            {
                Player p = new Player(playersArrayList.get(i).getName(), playersArrayList.get(i).getEmail(), playersArrayList.get(i).getImg());
                filterList.add(p);
                Adapter adapter = new Adapter(this, filterList);
                listView1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
            else if(playersArrayList.get(i).getEmail().toUpperCase().equals(searchTxt))
            {
                Player p = new Player(playersArrayList.get(i).getName(), playersArrayList.get(i).getEmail(), playersArrayList.get(i).getImg());
                filterList.add(p);
                Adapter adapter = new Adapter(this, filterList);
                listView1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
            else
            {
                Adapter adapter = new Adapter(this, filterList);
                listView1.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
