package com.example.abdulhafeez.multivaluelist;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.*;
public class CustomAdapter extends ArrayAdapter<String>
{
    Context context;
    String[] players;
    int[] images;

    public CustomAdapter(Context context, String[] players, int[]images)
    {
        super(context, R.layout.rowmodel, players);
        this.context = context;
        this.players = players;
        this.images = images;
    }

    public View getView(int position, View view, ViewGroup viewGroup)
    {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.rowmodel, null);
        }

        TextView nameTv = (TextView) view.findViewById(R.id.nameTv);
        ImageView img = (ImageView) view.findViewById(R.id.imageView1);
        nameTv.setText(players[position]);
        img.setImageResource(images[position]);
        return view;
    }
}

