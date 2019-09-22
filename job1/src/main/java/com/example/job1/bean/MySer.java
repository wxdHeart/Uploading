package com.example.job1.bean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface MySer {
    public String url_r="http://static.owspace.com/";
    @GET("?c=api&a=getList&page_id=0")
    Observable<User> getUser();
}
