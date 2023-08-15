package inducesmile.com.androidrecyclerview;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.*;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

public class CustomAdapter extends ArrayAdapter<String>
{
    Context context;
    String[] players;
    String[] images;

    public CustomAdapter(MainActivity context, String[] players, String[] images)
    {
        super((Context) context, R.layout.rowmodel, players);
        this.context = (Context) context;
        this.players = players;
        this.images = images;
    }

    public View getView(int position, View view, ViewGroup viewGroup)
    {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.rowmodel, null);
        }

        TextView nameTv = (TextView) view.findViewById(R.id.person_name);
        ImageView img = (ImageView) view.findViewById(R.id.person_image);

//        Button request_button = (Button) view.findViewById(R.id.request_button);
//        request_button.setBackgroundColor(Color.parseColor("#FFB6B546"));

        nameTv.setText(players[position]);
        Picasso.with(context).load(images[position]).error(R.mipmap.ic_launcher)
                .into(img, new com.squareup.picasso.Callback(){
            @Override
            public void onSuccess() {}
            @Override
            public void onError() {}
        });
        return view;
    }
}
