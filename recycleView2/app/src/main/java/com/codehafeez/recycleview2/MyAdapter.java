package com.codehafeez.recycleview2;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

    List<UserData> list = new ArrayList<>();
    ItemClickListener itemClickListener;
    
    public MyAdapter(List<UserData> list) {
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new MyHolder(view);
    }

    @SuppressLint("RecyclerView")
    public void onBindViewHolder(MyHolder holder, int position) {
        final UserData userData = list.get(position);
        holder.tv_name.setText(userData.getName());
        holder.tv_email.setText(userData.getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                // Toast.makeText(view.getContext(), "Position: "+position, Toast.LENGTH_LONG).show();
//                Toast.makeText(view.getContext(), "Obj: "+userData.email, Toast.LENGTH_LONG).show();
                itemClickListener.OnItemClick(position,userData);
            }
        });

        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        TextView tv_name,tv_email,tv_delete;
        public MyHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name_item);
            tv_email = itemView.findViewById(R.id.tv_email_item);
            tv_delete = itemView.findViewById(R.id.tv_delete_item);
        }
    }

    public void UpdateData(int position,UserData userData){
        list.remove(position);
        list.add(userData);
        notifyItemChanged(position);
        notifyDataSetChanged();
    }
}
