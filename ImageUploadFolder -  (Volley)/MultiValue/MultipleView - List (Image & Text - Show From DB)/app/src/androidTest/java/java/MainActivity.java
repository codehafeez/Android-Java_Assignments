package java;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import inducesmile.com.androidrecyclerview.R;

public class MainActivity extends ActionBarActivity {

    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(null);

        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(MainActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    private List<ItemObject> getAllItemList()
    {
        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Peter James", R.drawable.face));
        allItems.add(new ItemObject("Henry Jacobs", R.drawable.face));
        allItems.add(new ItemObject("Bola Olumide", R.drawable.face));
        allItems.add(new ItemObject("Chidi Johnson", R.drawable.face));
        allItems.add(new ItemObject("DeGordio Puritio", R.drawable.face));
        allItems.add(new ItemObject("Gary Cook", R.drawable.face));
        allItems.add(new ItemObject("Edith Helen", R.drawable.face));
        allItems.add(new ItemObject("Kingston Dude", R.drawable.face));
        allItems.add(new ItemObject("Edwin Bent", R.drawable.face));
        allItems.add(new ItemObject("Grace Praise", R.drawable.face));

        return allItems;
    }
}
