package com.example.job2.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.job2.R;
import com.example.job2.bean.User;


import java.util.ArrayList;

public class RecyAdap extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<User.ResultsEntity> list;
    private Context context;



    public RecyAdap(ArrayList<User.ResultsEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
              View view = View.inflate(context, R.layout.item, null);
              return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        User.ResultsEntity resultsEntity = list.get(position);
            ViewHolder holder1 = (ViewHolder) holder;
            Glide.with(context).load(resultsEntity.getUrl())
                    .into(holder1.img);
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                        onloog.loog(position);
                    return false;
                }
            });
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
    public OnLoogClick onloog;

    public void setOnloog(OnLoogClick onloog) {
        this.onloog = onloog;
    }

    public interface OnLoogClick{
        void loog(int position);
    }
}
