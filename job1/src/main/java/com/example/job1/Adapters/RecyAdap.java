package com.example.job1.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.CamcorderProfile;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.job1.BaseApp;
import com.example.job1.R;
import com.example.job1.bean.DatasBean;
import com.example.job1.bean.User;
import com.example.job1.dao.DatasBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.media.CamcorderProfile.get;

public class RecyAdap extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<DatasBean> list;
    private Context context;
    private HashSet<String> hashSet=new HashSet<>();
    private SharedPreferences.Editor edit;
    private SharedPreferences mima;
    private SharedPreferences.Editor edit1;
    private Set<String> position1;

    public RecyAdap(ArrayList<DatasBean> list, Context context) {
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
        mima = context.getSharedPreferences("mima", context.MODE_PRIVATE);
        edit1 = mima.edit();
        position1 = mima.getStringSet("position", new HashSet<String>());
        hashSet.addAll(position1);
        return new ViewHolder(view);

    }
    @SuppressLint("CommitPrefEdits")
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        DatasBean resultsEntity = list.get(position);

            ViewHolder holder1 = (ViewHolder) holder;
            holder1.tv1.setText(resultsEntity.getTitle());
            holder1.tv2.setText(resultsEntity.getAuthor());
            Glide.with(context).load(resultsEntity.getThumbnail())
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(holder1.img);
            ((ViewHolder) holder).btt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = ((ViewHolder) holder).btt.getText().toString();
                    if (s.equals("关注")){
                        DatasBean datasBean = list.get(position);
                        DatasBeanDao datasBeanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
                        datasBeanDao.insert(datasBean);
                        ((ViewHolder) holder).btt.setText("取消");
                        
                        String s2 = ((ViewHolder) holder).btt.getText().toString();
                        hashSet.add(position+"");
                        edit1.putStringSet("position",hashSet);
                        edit1.commit();
                    }else {
                       DatasBean datasBean1 = list.get(position);
                        DatasBeanDao datasBeanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
                        datasBeanDao.delete(datasBean1);
                        ((ViewHolder) holder).btt.setText("关注");
                        hashSet.remove(position+"");
                        edit1.putStringSet("position",hashSet);
                        edit1.commit();

                    }
                 //   Toast.makeText(context, "okok", Toast.LENGTH_SHORT).show();
                }
            });
        this.position1 = mima.getStringSet("position", new HashSet<String>());
        for (String s: position1) {
                    if (String.valueOf(position).equals(s)){
                        ((ViewHolder) holder).btt.setText("取消");
                    }
                }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tv1;
        TextView tv2;
        Button btt;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            btt = itemView.findViewById(R.id.btt);
        }
    }
        private OnLoogClick onClick;

    public void setOnClick(OnLoogClick onClick) {
        this.onClick = onClick;
    }

    public interface OnLoogClick{
           void onclick(int position);
       }
}
