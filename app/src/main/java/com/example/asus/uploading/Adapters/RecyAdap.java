package com.example.asus.uploading.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.uploading.Bean.User;
import com.example.asus.uploading.R;

import java.util.ArrayList;

public class RecyAdap extends RecyclerView.Adapter<RecyAdap.ViewHolder> {
    private Context context;
    private ArrayList<User> list;

    public RecyAdap(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_home, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = list.get(position);
        holder.my_content.setText(user.getContent());
        holder.mytitle.setText(user.getConadd());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView my_content;
        TextView mytitle;

        public ViewHolder(View itemView) {
            super(itemView);
            my_content = itemView.findViewById(R.id.my_content);
            mytitle = itemView.findViewById(R.id.mytitle);

        }
    }
}
