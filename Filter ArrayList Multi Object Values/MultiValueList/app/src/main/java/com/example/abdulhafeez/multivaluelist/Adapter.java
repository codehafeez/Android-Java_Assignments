package com.example.abdulhafeez.multivaluelist;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class Adapter extends BaseAdapter
{
    Context context;
    ArrayList<Player> players;

    public Adapter(Context context, ArrayList<Player> players){
        this.context = context;
        this.players = players;
    }

    @Override public int getCount() { return players.size(); }
    @Override public Object getItem(int position) { return players.get(position); }
    @Override public long getItemId(int position) { return players.indexOf(getItem(position)); }

    @Override public View getView(int position, View view, ViewGroup viewGroup)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null) { view = layoutInflater.inflate(R.layout.rowmodel, null); }

        TextView nameTxt = (TextView) view.findViewById(R.id.nameTv);
        ImageView img = (ImageView) view.findViewById(R.id.imageView1);
        nameTxt.setText(players.get(position).getName());
        img.setImageResource(players.get(position).getImg());

        return view;
    }
}
