package com.example.job2.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.job2.R;
import com.example.job2.bean.User;

import java.util.ArrayList;

public class FragmentPageAdap extends PagerAdapter {
    private ArrayList<User.ResultsEntity> list;
    User.ResultsEntity bean;

    public FragmentPageAdap(ArrayList<User.ResultsEntity> list, User.ResultsEntity bean) {
        this.list = list;
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(container.getContext(), R.layout.vp_ryhsb, null);
        ImageView vp = view.findViewById(R.id.img1);
        if (position==0){
            Glide.with(container.getContext()).load(list.get(position).getUrl()).into(vp);
        }else {
            Glide.with(container.getContext()).load(list.get(position).getUrl()).into(vp);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
