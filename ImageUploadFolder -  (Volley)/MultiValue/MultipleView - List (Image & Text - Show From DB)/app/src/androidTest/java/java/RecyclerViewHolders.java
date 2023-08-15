package java;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import inducesmile.com.androidrecyclerview.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder{

    public TextView personName;
    public ImageView personPhoto;

    public RecyclerViewHolders(View itemView) {
        super(itemView);

        personName = (TextView)itemView.findViewById(R.id.person_name);
        personPhoto = (ImageView)itemView.findViewById(R.id.circleView);
    }
}
