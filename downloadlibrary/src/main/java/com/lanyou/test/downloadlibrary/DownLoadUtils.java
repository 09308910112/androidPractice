package com.lanyou.test.downloadlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.lanyou.test.downloadlibrary.Utils.PermissionsUtils;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/9/30.
 */
public class DownLoadUtils {
    static DownloadService.DownloadBinder downloadBinder;
    static ServiceConnection conn;
    /**
     * 下载的apk url
     */
    public static String downloadUrl;

    /**
     * 开始下载
     *
     * @param mContext
     */
    public static void startDownload(Context mContext, String url) {
        if (PermissionsUtils.hasWriteStoragePermission(mContext)) {
            downloadUrl = url;
            initServiceConn(mContext);
            bindDownloadService(mContext);
        } else {
            Toast.makeText(mContext, "请打开写入sd卡的权限", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 暂停下载
     */
    public static void pauseDownload() {
        if (downloadBinder != null) {
            downloadBinder.pauseDownload();
        }
    }

    /**
     * 取消下载
     */
    public static void cancelDownload() {
        if (downloadBinder != null) {
            downloadBinder.cancelDownload();
        }
    }

    private static void bindDownloadService(Context mContext) {
        Intent intent = new Intent(mContext, DownloadService.class);
        mContext.startService(intent);
        mContext.bindService(intent, conn, BIND_AUTO_CREATE);
    }

    private static void initServiceConn(final Context mContext) {
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                downloadBinder = (DownloadService.DownloadBinder) service;
                downloadBinder.startDownload(mContext, downloadUrl);
                Log.e(Constants.TAG, "已连接");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }
}
