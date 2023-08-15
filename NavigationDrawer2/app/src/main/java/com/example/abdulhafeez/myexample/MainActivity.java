package com.example.abdulhafeez.myexample;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    ArrayList<String> dataArray_right=new ArrayList<String>();
    ArrayList<Object> objectArray_right=new ArrayList<Object>();

    DrawerLayout mDrawerlayout;
    ListView mDrawerList_Right;
    ActionBarDrawerToggle mDrawerToggle;
    ImageButton imgRightMenu;

    ListItemsAdapter_Right Right_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //===============Initialization of Variables=========================//

        mDrawerlayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList_Right=(ListView)findViewById(R.id.drawer_list_right);
        imgRightMenu=(ImageButton)findViewById(R.id.imgRightMenu);
        mDrawerlayout.setDrawerListener(mDrawerToggle);


        //============== Define a Custom Header for Navigation drawer=================//

        LayoutInflater inflator=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflator.inflate(R.layout.header, null);
        imgRightMenu=(ImageButton)v.findViewById(R.id.imgRightMenu);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1281A9")));
        getSupportActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getSupportActionBar().setCustomView(v);

        imgRightMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerlayout.openDrawer(mDrawerList_Right);
            }
        });

        Fill_RightList();
        RefreshListView();
    }


    public void RefreshListView() {
        objectArray_right.clear();
        for (int i = 0; i < dataArray_right.size(); i++) {
            Object obj = new Object();
            objectArray_right.add(obj);
        }
        Log.d("object array", "" + objectArray_right.size());
        Right_Adapter = new ListItemsAdapter_Right(objectArray_right, 1);
        mDrawerList_Right.setAdapter(Right_Adapter);
    }

    public void Fill_RightList() {
        dataArray_right.clear();
        dataArray_right.add("Option 1");
        dataArray_right.add("Option 2");
        dataArray_right.add("Option 3");
        dataArray_right.add("Option 4");
        dataArray_right.add("Option 5");
    }

    //=============Right Listview Adapter Implementation;================//

    private class ListItemsAdapter_Right extends ArrayAdapter<Object> {
        ViewHolder holder1;
        public ListItemsAdapter_Right(List<Object>items,int x) {
            super(MainActivity.this, android.R.layout.simple_list_item_single_choice, items);
        }

        @Override
        public String getItem(int position) {
            return dataArray_right.get(position);
        }

        public int getItemInteger(int pos) {
            return pos;
        }

        @Override
        public int getCount() {
            return dataArray_right.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflator=getLayoutInflater();
            convertView=inflator.inflate(R.layout.data, null);
            holder1=new ViewHolder();
            holder1.text=(TextView)convertView.findViewById(R.id.txtData);
            holder1.iv=(ImageView)convertView.findViewById(R.id.imgView);
            convertView.setTag(holder1);
            String text=dataArray_right.get(position);
            holder1.text.setText(dataArray_right.get(position));
            return convertView;
        }
    }

    private class ViewHolder {
        TextView text,textcounter;
        ImageView iv;
    }
}
