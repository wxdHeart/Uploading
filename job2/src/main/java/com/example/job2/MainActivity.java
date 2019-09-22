package com.example.job2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.job2.Adapters.FragmentPageAdap;
import com.example.job2.Adapters.RecyAdap;
import com.example.job2.bean.User;
import com.example.job2.molder.MainMolder;
import com.example.job2.presenter.MainPresenter;
import com.example.job2.views.MainViews;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViews {

    private ViewPager mMyvp;
    private RecyclerView mMyrecy;
    private ArrayList<User.ResultsEntity> list;
    private RecyAdap recyAdap;
    private int page;
    /**
     * 111111
     */
    private TextView mShow;
    private FragmentPageAdap fragmentPageAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MainPresenter mainPresenter = new MainPresenter(this, new MainMolder());
        mainPresenter.getOp();
    }

    private void initView() {
        mMyvp = (ViewPager) findViewById(R.id.myvp);
        mMyrecy = (RecyclerView) findViewById(R.id.myrecy);
        mShow = (TextView) findViewById(R.id.show);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mMyrecy.setLayoutManager(staggeredGridLayoutManager);
        list = new ArrayList<>();
        recyAdap = new RecyAdap(list, MainActivity.this);
        mMyrecy.setAdapter(recyAdap);

        recyAdap.setOnloog(new RecyAdap.OnLoogClick() {
            @Override
            public void loog(int position) {
                initData();
                Toast.makeText(MainActivity.this, "hahah", Toast.LENGTH_SHORT).show();
                page=position;
            }


        });

    }

    private void initData() {
        User.ResultsEntity resultsEntity = list.get(page);
        fragmentPageAdap = new FragmentPageAdap(list, resultsEntity);
        mMyvp.setAdapter(fragmentPageAdap);
        mMyvp.setVisibility(View.VISIBLE);
        mMyrecy.setVisibility(View.INVISIBLE);
        initAss();
    }


    private void initAss() {
        showTv(1,list.size());
        mMyvp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                showTv(position + 1, list.size());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void showTv(int index, int all) {
        mShow.setText("第" + index + "张/共" + all + "张");

    }

    @Override
    public void onSucce(User user) {
        List<User.ResultsEntity> results = user.getResults();
        list.addAll(results);
        recyAdap.notifyDataSetChanged();
    }

    @Override
    public void onFlie(String str) {

    }
}
