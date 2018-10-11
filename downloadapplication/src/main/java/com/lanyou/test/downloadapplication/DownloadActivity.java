package com.lanyou.test.downloadapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

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

    public void dialog(View view) {


       /* AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DownloadActivity.this, "ok", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DownloadActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setMessage("message")
                .setTitle("title");
        AlertDialog dialog = builder.create();
        dialog.show();*/
    }
}
