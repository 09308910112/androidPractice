package com.lanyou.test.downloadapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.lanyou.test.downloadapplication.download.DownloadService;

public class DownloadActivity extends AppCompatActivity {

    public  String downloadUrl = "http://vitota.venucia.com/app/201808/e71bba25be44280d51d1a68a796d540e.apk";
    private DownloadService.DownloadBinder downloadBinder;
    ServiceConnection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        // TODO:  2018/9/22 lpengcheng 要处理写入的权限
        initServiceConn();
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
        bindService(intent,conn,BIND_AUTO_CREATE);
    }

    private void initServiceConn() {
       conn  = new ServiceConnection(){

          @Override
          public void onServiceConnected(ComponentName name, IBinder service) {
               downloadBinder=  (DownloadService.DownloadBinder) service;
              Log.e("download","已连接");
          }

          @Override

          public void onServiceDisconnected(ComponentName name) {

          }
      };
    }

    public void start(View view){
        downloadBinder.startDownload(downloadUrl);
    }

    public void pause(View view){
        downloadBinder.pauseDownload();
    }

    public void cancel(View view){
        downloadBinder.cancelDownload();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
