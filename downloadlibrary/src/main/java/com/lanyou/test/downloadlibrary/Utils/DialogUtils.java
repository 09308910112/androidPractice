package com.lanyou.test.downloadlibrary.Utils;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;

import com.lanyou.test.downloadlibrary.Constants;
import com.lanyou.test.downloadlibrary.DownloadService;
import com.lanyou.test.downloadlibrary.MyApp;
import com.lanyou.test.downloadlibrary.dialog.DownloadDialog;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/11.
 */
public class DialogUtils {
    private DialogUtils() {

    }

    private static DialogUtils instance;
    DownloadDialog downloadDialog;

    /**
     * 获取单例子dialogUtils
     *
     * @return
     */
    public static synchronized DialogUtils getInstance() {
        if (instance == null) {
            synchronized (DialogUtils.class) {
                if (instance == null) {
                    instance = new DialogUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 创建dialog
     */
    public synchronized Dialog showDialog(Context mContext) {
        if (downloadDialog == null) {
            synchronized (DialogUtils.this) {
                if (downloadDialog == null) {
                    downloadDialog = new DownloadDialog(mContext);
                    downloadDialog.setCancelable(true);
                    initListener();
                }
            }
        }
        downloadDialog.show();
        updateDialog();
        return downloadDialog;
    }

    private void initListener() {
        downloadDialog.setOnRightListener("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int downloadStatus = DownloadService.getBinder().getDownloadStatus();
                if (downloadStatus == Constants.DOWNLOAD_TYPE_FAILED) {
                    DownloadService.getBinder().cancelDownload();
                    dismissDialog();
                } else if (downloadStatus == Constants.DOWNLOAD_TYPE_PAUSED) {
                    DownloadService.getBinder().continueDownload();
                } else if (downloadStatus == Constants.DOWNLOAD_TYPE_CANCELED) {
                    DownloadService.getBinder().cancelDownload();
                    dismissDialog();
                } else if (downloadStatus == Constants.DOWNLOAD_TYPE_DOWNLOAD) {
                    DownloadService.getBinder().pauseDownload();
                }
            }
        });
        downloadDialog.setOnLeftListener("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadDialog.dismiss();
            }
        });
    }


    public void updateProgress(int progress) {
        downloadDialog.setProgress(progress);
        updateDialog();
    }

    public void updateDialog() {
        final int downloadStatus = DownloadService.getBinder().getDownloadStatus();
        if (downloadStatus == Constants.DOWNLOAD_TYPE_SUCCESS) {
            String path = Constants.getLocalDownloadApkFile().getPath();
            Log.e(Constants.TAG, "要安装的本地路径：" + path);
            AndroidUtil.installApk(MyApp.getContext(), path);
            dismissDialog();
            return;
        }

        String sureButton = Constants.getDownloadStatusString(downloadStatus);
        String title = Constants.getDownloadTitle(downloadStatus);
        downloadDialog.setRightext(sureButton);
        downloadDialog.setTitle(title);
    }

    /**
     * 取消dialog
     */
    public void dismissDialog() {
        if (downloadDialog != null) {
            downloadDialog.dismiss();
        }
    }
}
