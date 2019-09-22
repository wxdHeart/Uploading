package com.example.asus.uploading;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.asus.uploading.Adapters.RecyAdap;
import com.example.asus.uploading.Bean.User;
import com.example.asus.uploading.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 搜索
     */
    private Button mBttSeek;
    /**
     * 添加
     */
    private Button mBttAdd;
    private RecyclerView mRecyHome;
    private Toolbar mMytoo;
    private ArrayList<User> list;
    private RecyAdap recyAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mRecyHome = (RecyclerView) findViewById(R.id.recy_home);
        mMytoo = (Toolbar) findViewById(R.id.mytoo);
        mBttSeek = (Button) findViewById(R.id.btt_seek);
        mBttSeek.setOnClickListener(this);
        mBttAdd = (Button) findViewById(R.id.btt_add);
        mBttAdd.setOnClickListener(this);
        mMytoo.setTitle("");
        setSupportActionBar(mMytoo);
        mRecyHome.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
        list = new ArrayList<>();
        UserDao userDao = BaseApp.getInstance().getDaoSession().getUserDao();
        //    userDao.insert(new User(null,"haha","hehe"));
        List<User> users = userDao.loadAll();
        list.addAll(users);

        mRecyHome.addItemDecoration(new DividerItemDecoration(Main2Activity.this,1));
        recyAdap = new RecyAdap(Main2Activity.this, list);
        mRecyHome.setAdapter(recyAdap);
        recyAdap.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btt_seek:
                startActivity(new Intent(Main2Activity.this, SeekActivity.class));
                break;
            case R.id.btt_add:
               startActivity(new Intent(Main2Activity.this, AddActivitys.class));
                break;
        }
    }
}
