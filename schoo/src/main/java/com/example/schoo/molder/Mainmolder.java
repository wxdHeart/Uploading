package com.example.schoo.molder;

import com.example.schoo.Bean.Myservice;
import com.example.schoo.Bean.User;
import com.example.schoo.mainView.Viewmain;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mainmolder implements molderMain{

    @Override
    public void getData(Viewmain viewmain) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1/")
                .build();
        Myservice myservice = retrofit.create(Myservice.class);
        Observable<User> sta = myservice.getSta();

    }
}
