package com.example.download;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String fileUrl = "http://cdn.banmi.com/ ";//文件的网络路径

    @GET("banmiapp/apk/banmi_330.apk")
    Call<ResponseBody> downloadFile();
}
