package com.example.abdulhafeez.multivaluenew;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
public class UserCustomAdapter extends ArrayAdapter<User> {

    Context context;
    int layoutResourceId;
    ArrayList<User> data = new ArrayList<User>();

    public UserCustomAdapter(Context context, int layoutResourceId, ArrayList<User> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        UserHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new UserHolder();
            holder.person_name = (TextView) row.findViewById(R.id.person_name);
            holder.person_image = (ImageView) row.findViewById(R.id.person_image);
            holder.request_button = (Button) row.findViewById(R.id.request_button);
            row.setTag(holder);
        } else { holder = (UserHolder) row.getTag(); }

        User user = data.get(position);
        // Username
        holder.person_name.setText(user.getName());
        // User Image
        Picasso.with(context).load(user.getAddress()).error(R.mipmap.ic_launcher)
                .error(R.drawable.face).into(holder.person_image, new com.squareup.picasso.Callback(){
            @Override public void onSuccess() {} @Override public void onError() {}
        });
        // User Request Button
        holder.request_button.setText(user.getLocation());
        holder.request_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position+" : Requuest button Clicked",Toast.LENGTH_LONG).show();
            }
        });
        return row;
    }

    static class UserHolder {
        TextView person_name;
        ImageView person_image;
        Button request_button;
    }
}