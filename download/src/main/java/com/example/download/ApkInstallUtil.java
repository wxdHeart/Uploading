package com.example.download;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;

import java.io.File;

/**
 * 使用此类进行安装apk的步骤
 * 1.在清单中配置好  内容提供者  android.support.v4.content.FileProvider
 * 2.文件下载完成后，调用此类的installApk 方法，传入 上下文和安装文件的路径
 * 3.安装过程中需要给本app设置安装未知apk文件的允许权限，允许后会回调到 Activity的onActivityResult方法中
 * 重新安装（授权后，需要再次安装）
 */

public class ApkInstallUtil {
    public static final int UNKNOWN_CODE = 2019;
    //调用安装的方法，进行判断是哪种sdk的版本，进行对应的安装
    public static void installApk(Context context, String path) {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){ //8.0 26以上
            startInstallO(context,path);
        }else if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){//7.0 24到26之间
            startInstallN(context,path);
        }else {                                          //7.0之下 6.x  5.x。。。
            startInstall(context,path);
        }
    }

    /**
     *android1.x-6.x
     *@param path 文件的路径
     */
    public static void startInstall(Context context, String path) {
        Intent install = new Intent(Intent.ACTION_VIEW);
        install.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
        install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(install);
    }

    /**
     * android7.x
     * @param path 文件路径
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void startInstallN(Context context, String path) {
        //参数1 上下文, 参数2 在AndroidManifest中的内容提供者中的android:authorities值, 参数3  下载的文件
        Uri apkUri = FileProvider.getUriForFile(context, "day15.file.download", new File(path));
        Intent install = new Intent(Intent.ACTION_VIEW);
        //由于没有在Activity环境下启动Activity,设置下面的标签
        install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //添加这一句表示对目标应用临时授权该Uri所代表的文件
        install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        install.setDataAndType(apkUri, "application/vnd.android.package-archive");
        context.startActivity(install);
    }

    /**
     * android8.x
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void startInstallO(final Context context, String path) {
        //获取是否允许私有的文件夹可以访问
        boolean isGranted = context.getPackageManager().canRequestPackageInstalls();
        if (isGranted) //允许过了，直接装
            startInstallN(context,path);//安装应用的逻辑(写自己的就可以)
        else new AlertDialog.Builder(context) //没有允许过，请求允许，授权
                .setCancelable(false)
                .setTitle("安装应用需要打开未知来源权限，请去设置中开启权限")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface d, int w) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
                        Activity act = (Activity) context;
                        act.startActivityForResult(intent, UNKNOWN_CODE);
                    }
                })
                .show();
    }

}
