package com.lanyou.test.downloadlibrary;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lanyou.test.downloadlibrary.Utils.DialogUtils;
import com.lanyou.test.downloadlibrary.dialog.DownloadDialog;

import java.io.File;


/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/9/17.
 */
public class DownloadService extends Service {
    String NOTIFICATION_CHANNEL_ID = "com.example.simpleapp";
    private static DownloadBinder mBinder;
    DownloadTask downloadTask;

    public int downloadStatus = Constants.DOWNLOAD_TYPE_DOWNLOAD;


    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
            downloadStatus = Constants.DOWNLOAD_TYPE_DOWNLOAD;
            DialogUtils.getInstance().updateDialogUI(progress);
            getNotificationManager().notify(1, getNotification("下载中....", progress));
        }

        @Override
        public void onSuccess() {
            downloadTask = null;
            downloadStatus = Constants.DOWNLOAD_TYPE_SUCCESS;
            stopForeground(true);
            DialogUtils.getInstance().updateDialogUI(100);
            getNotificationManager().notify(1, getNotification("下载成功", -1));
            Toast.makeText(DownloadService.this, "下载成功...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed() {
            downloadTask = null;
            downloadStatus = Constants.DOWNLOAD_TYPE_FAILED;
            stopForeground(true);
            DialogUtils.getInstance().dismissDialog();
            getNotificationManager().notify(1, getNotification("下载失败", -1));
            Toast.makeText(DownloadService.this, "下载失败...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            downloadTask = null;
            downloadStatus = Constants.DOWNLOAD_TYPE_PAUSED;
            Toast.makeText(DownloadService.this, "下载停止...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCanceled() {
            downloadTask = null;
            downloadStatus = Constants.DOWNLOAD_TYPE_CANCELED;
            stopForeground(true);
            DialogUtils.getInstance().dismissDialog();
            Toast.makeText(DownloadService.this, "下载已取消...", Toast.LENGTH_SHORT).show();
        }
    };

    private Notification getNotification(String title, int progress) {
      /*  Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);*/
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        //builder.setContentIntent(pendingIntent);
        builder.setContentTitle(title);
        if (progress >= 0) {
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);

        }
        return builder.build();
    }

    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public IBinder onBind(Intent intent) {
        if (mBinder == null) {
            mBinder = new DownloadBinder();
        }
        return mBinder;
    }


    String downloadUrl;
    Context context;

    public class DownloadBinder extends Binder {

        public void startDownload(Context mContext, String url) {
            if (downloadTask == null) {
                context = mContext;
                initProgressBar(mContext);
                downloadUrl = url;
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(downloadUrl);
                setStartForeground();
                Toast.makeText(DownloadService.this, "正在下载...", Toast.LENGTH_SHORT).show();
            }
        }

        private void initProgressBar(Context mContext) {
            DialogUtils.getInstance().showDialog( mContext);
        }

        public void pauseDownload() {
            if (downloadTask != null) {
                downloadTask.pausedDownLoad();
            }
        }

        public void cancelDownload() {
            if (downloadTask != null) {
                downloadTask.cancelDownLoad();
            }
            if (downloadUrl != null) {
                String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
                String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                        .getPath();
                File file = new File(directory + "/" + fileName);
                if (file.exists()) {
                    file.delete();
                }
                getNotificationManager().cancel(1);
                stopForeground(true);
                Toast.makeText(DownloadService.this, "取消下载", Toast.LENGTH_SHORT).show();
            }
        }

        /**
         * 解除绑定
         */
        public void unbindService(Context mContext, ServiceConnection conn) {
            mContext.unbindService(conn);
        }

        /**
         * 获取下载状态
         *
         * @return
         */
        public int getDownloadStatus() {
            return downloadStatus;
        }

    }

    private void setStartForeground() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            startMyOwnForeground();
        } else {
            startForeground(1, getNotification("下载中啊....", 0));
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private void startMyOwnForeground() {
        String channelName = "下载提示";
        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager
                .IMPORTANCE_NONE);
        chan.setLightColor(Color.RED);
        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(chan);
        startForeground(1, getNotification("下载中啊....", 0));
    }

    public static DownloadBinder getBinder() {
        return mBinder;
    }
}
