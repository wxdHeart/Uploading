package com.example.job1.presenter;


import com.example.job1.bean.User;
import com.example.job1.molder.MolderMain;
import com.example.job1.views.MainViews;

public class MainPresenter implements MainViews,Presenter {
    private MainViews mainViews;
    private MolderMain molderMain;

    public MainPresenter(MainViews mainViews, MolderMain molderMain) {
        this.mainViews = mainViews;
        this.molderMain = molderMain;
    }

    @Override
    public void getOp() {
        molderMain.getData(this);
    }

    @Override
    public void onSucce(User user) {
        mainViews.onSucce(user);
    }

    @Override
    public void onFlie(String str) {

    }
}
