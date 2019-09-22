package com.example.asus.uploading;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.uploading.Bean.User;
import com.example.asus.uploading.dao.UserDao;

public class AddActivitys extends AppCompatActivity implements View.OnClickListener {

    /**
     * 保存
     */
    private Button mBttSave;
    /**
     * 请输入内容:
     */
    private EditText mEtContent;
    /**
     * 请输入标题：
     */
    private EditText mEtTitle;
    private Toolbar mMytoob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        initView();
    }

    private void initView() {
        mBttSave = (Button) findViewById(R.id.btt_save);
        mBttSave.setOnClickListener(this);
        mEtContent = (EditText) findViewById(R.id.et_content);
        mEtTitle = (EditText) findViewById(R.id.et_title);

        mMytoob = (Toolbar) findViewById(R.id.mytoob);
        mMytoob.setTitle("");
        setSupportActionBar(mMytoob);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btt_save:
                String s = mEtContent.getText().toString();
                String s1 = mEtTitle.getText().toString();
                UserDao userDao = BaseApp.getInstance().getDaoSession().getUserDao();
                userDao.insert(new User(null, s, s1));
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddActivitys.this, Main2Activity.class));
                break;
        }
    }
}
