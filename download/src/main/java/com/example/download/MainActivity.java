package com.example.download;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String fileUrl = "http://cdn.banmi.com/banmiapp/apk/banmi_330.apk ";//文件的网络路径
    private ProgressBar mPb;
    /**
     * 下载
     */
    private Button mBtn;
    private File savaFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        EventBus.getDefault().register(this);//注册eventbus

        checkPremisstion();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMsg(PbMsg pbMsg){
        switch (pbMsg.getI()){
            case 0://访问失败
                Toast.makeText(this, "访问失败，请求检查网络", Toast.LENGTH_SHORT).show();
                break;
            case 1://设置pb的最大值和文件一致
                mPb.setMax((int)pbMsg.getMax());//如果max值超过21亿，不能够这样，需要进行百分比的转换
                break;
            case 2:
                mPb.setProgress(pbMsg.getProgress());//把进度设置到进度条中
                Log.i("111", "getMsg22222222222222: "+pbMsg.getProgress());
                break;
            case 3:
                Toast.makeText(this, "下载完成", Toast.LENGTH_SHORT).show();
                //对于当前教学，三种下载，完成后都会走此方法，接着安装
                ApkInstallUtil.installApk(this,savaFile.getPath());//下载完成，在主线程中安装
                break;
        }
    }

    private void checkPremisstion() {
        //检查 sdcard读权限
        int i = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (i != PackageManager.PERMISSION_GRANTED) {//没有权限，申请权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }

        int j = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (j != PackageManager.PERMISSION_GRANTED) {//没有权限，申请权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        }

    }


    private void initView() {
        mPb = (ProgressBar) findViewById(R.id.pb);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                downloadFile();
                break;
        }
    }

    private void downloadFile() {
        //第一种 ok的下载
//        ThreadManager.getInstance().execute(new Runnable() {
//            @Override
//            public void run() {
//                ok();
//            }
//        });
        //第二种 retrofit
//        retrofit();

        ThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                http();
            }
        });

    }

    private void http() {
        savaFile = new File("/storage/emulated/0/c.apk");
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if(conn.getResponseCode() == 200){
                InputStream inputStream = conn.getInputStream();
                long max = conn.getContentLength();
                savaFile(inputStream,max);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void retrofit() {
        savaFile = new File("/storage/emulated/0/b.apk");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.fileUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        retrofit2.Call<ResponseBody> call =apiService.downloadFile();
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                InputStream inputStream = response.body().byteStream();//得到文件的数据流
                long max = response.body().contentLength();//得到文件的长度

                savaFile(inputStream,max);
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {

                //请求失败，发送失败信息
                EventBus.getDefault().post(new PbMsg(0,0,0));//发送失败消息
            }
        });
    }

    public void ok(){
        //本地的保存路径
        savaFile = new File("/storage/emulated/0/a.apk");
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(fileUrl)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求失败，发送失败信息
                EventBus.getDefault().post(new PbMsg(0,0,0));//发送失败消息
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final InputStream inputStream = response.body().byteStream();//得到文件的数据流
                final long max = response.body().contentLength();//得到文件的长度

                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        savaFile(inputStream,max);
                    }
                }.start();
            }
        });
    }

    //保存文件的方法
    private void savaFile(InputStream is, long max) {
        EventBus.getDefault().post(new PbMsg(1,0,max)); //把文件的大小和pb同步
        //读取信息，写入信息
        int len = 0;
        byte[] buff = new byte[4096];//每次读取4k
        int count = 0;//记录读取了多少，用于进度显示
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(savaFile);//创建保存文件的输出流
            while ((len = is.read(buff)) != -1){
                fos.write(buff,0,len);//把当前读取的写入
                count += len;//累计读取的数据的大小
                EventBus.getDefault().post(new PbMsg(2,count,max));//把进度传递出去，显示
                Log.i("111", "savaFile: 总大小："+max+",当前下载了："+count);

            }
            EventBus.getDefault().post(new PbMsg(3,0,0));//下载完成
            //apk下载完成，接着安装之

        } catch (Exception e) {
            e.printStackTrace();
            //关闭流
            try {
                if (is != null)
                    is.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //授权 可以安装apk的权限后，回调此方法，进行安装
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ApkInstallUtil.UNKNOWN_CODE) {

            ApkInstallUtil.installApk(this,savaFile.getPath());//再次执行安装流程，包含权限判等

        }

    }
}
