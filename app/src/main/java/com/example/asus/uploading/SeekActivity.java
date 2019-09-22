package com.example.asus.uploading;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.uploading.Adapters.RecyAdap;
import com.example.asus.uploading.Bean.User;
import com.example.asus.uploading.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class SeekActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 搜索
     */
    private Button mSeek;
    private Toolbar mMytoobar;
    private EditText mMtet;
    private RecyclerView mMyr;
    private ArrayList<User> list;
    private RecyAdap recyAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
    }

    private void initView() {
        mSeek = (Button) findViewById(R.id.seek);
        mSeek.setOnClickListener(this);
        mMytoobar = (Toolbar) findViewById(R.id.mytoobar);
        mMtet = (EditText) findViewById(R.id.mtet);
        mMyr = (RecyclerView) findViewById(R.id.myr);
        mMytoobar.setTitle("");
        setSupportActionBar(mMytoobar);
        mMyr.setLayoutManager(new LinearLayoutManager(SeekActivity.this));
        list = new ArrayList<>();
        mMyr.addItemDecoration(new DividerItemDecoration(SeekActivity.this,1));
        recyAdap = new RecyAdap(SeekActivity.this, list);
        mMyr.setAdapter(recyAdap);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.seek:
                String s = mMtet.getText().toString();
                UserDao userDao = BaseApp.getInstance().getDaoSession().getUserDao();
                User unique = userDao.queryBuilder().where(UserDao.Properties.Content.eq(s)).unique();
                if (unique==null){
                    Toast.makeText(this, "数据库不存在", Toast.LENGTH_SHORT).show();
                }else {
                    list.add(unique);
                    recyAdap.notifyDataSetChanged();
                }

                break;
        }
    }
}
