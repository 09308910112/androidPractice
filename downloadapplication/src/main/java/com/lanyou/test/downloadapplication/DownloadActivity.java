package com.lanyou.test.downloadapplication;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lanyou.test.downloadlibrary.DownLoadUtils;

public class DownloadActivity extends AppCompatActivity {

    public String downloadUrl = "http://vitota.venucia.com/app/201808/e71bba25be44280d51d1a68a796d540e.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
    }

    public void start(View view) {
        DownLoadUtils.startDownload(this, downloadUrl);
    }

    public void pause(View view) {
        DownLoadUtils.pauseDownload();
    }

    public void cancel(View view) {
        DownLoadUtils.cancelDownload();
    }
}
