package com.example.schoo.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Myservice {
    @GET("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<User> getSta();
}
