package com.example.job1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.job1.Adapters.RecyAdap;
import com.example.job1.bean.DatasBean;
import com.example.job1.bean.User;
import com.example.job1.molder.MainMolder;
import com.example.job1.presenter.MainPresenter;
import com.example.job1.views.MainViews;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViews {

    private Toolbar mMytoolbar;
    private RecyclerView mMyrecy;
    private ArrayList<DatasBean> list;
    private RecyAdap recyAdap;
    private int page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MainPresenter mainPresenter = new MainPresenter(this, new MainMolder());
        mainPresenter.getOp();
        initSp();
    }

    private void initSp() {

    }

    @Override
    public void onSucce(User user) {
        List<DatasBean> datas = user.getDatas();
        list.addAll(datas);
        recyAdap.notifyDataSetChanged();
    }

    @Override
    public void onFlie(String str) {

    }

    private void initView() {
        mMytoolbar = (Toolbar) findViewById(R.id.mytoolbar);
        mMyrecy = (RecyclerView) findViewById(R.id.myrecy);
        mMytoolbar.setTitle("");
        setSupportActionBar(mMytoolbar);
        list = new ArrayList<>();
        mMyrecy.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mMyrecy.addItemDecoration(new DividerItemDecoration(MainActivity.this,1));
        recyAdap = new RecyAdap(list, MainActivity.this);
        mMyrecy.setAdapter(recyAdap);
        recyAdap.setOnClick(new RecyAdap.OnLoogClick() {
            @Override
            public void onclick(int position) {
                page=position;
                initData();
            }


        });

    }
    private void initData() {
    }
}
