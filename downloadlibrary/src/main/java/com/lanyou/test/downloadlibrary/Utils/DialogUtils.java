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

    DownloadDialog downloadDialog;

    /**
     * 创建dialog
     */
    public synchronized Dialog showDialog(Context mContext) {
        if (downloadDialog == null) {
            synchronized (DialogUtils.this) {
                if (downloadDialog == null) {
                    downloadDialog = new DownloadDialog(mContext);
                    downloadDialog.setCanceledOnTouchOutside(true);
                }
            }
        }
        downloadDialog.show();
        updateDialog();
        return downloadDialog;
    }


    public void updateDialogUI(int progress) {
    /*    if (progress == 100) {
            DialogUtils.getInstance().dismissDialog();
            return;
        } else {*/
        downloadDialog.setProgress(progress);
        updateDialog();
        /* }*/
    }

    public void updateDialog() {
        final int downloadStatus = DownloadService.getBinder().getDownloadStatus();
        String sureButton = Constants.getDownloadStatusString(downloadStatus);
        String title = Constants.getDownloadTitle(downloadStatus);
        downloadDialog.setTitle(title);
        downloadDialog.setOnRightListener(sureButton, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO:  2018/10/11 lpengcheng
                //处理右击
                if (downloadStatus == Constants.DOWNLOAD_TYPE_SUCCESS) {
                    String path = Constants.getLocalDownloadApkFile().getPath();
                    Log.e("download", "要安装的本地路径：" + path);
                    AndroidUtil.installApk(MyApp.getContext(), path);
                    // dismissDialog();
                } /*else if (downloadStatus == Constants.DOWNLOAD_TYPE_FAILED) {
                    retValue = "确定";
                } else if (downloadStatus == Constants.DOWNLOAD_TYPE_PAUSED) {
                    retValue = "继续下载";
                } else if (downloadStatus == Constants.DOWNLOAD_TYPE_CANCELED) {
                    retValue = "确定";
                } else if (downloadStatus == Constants.DOWNLOAD_TYPE_DOWNLOAD) {
                    retValue = "暂停";
                }*/

            }
        });

        downloadDialog.setOnLeftListener("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadDialog.dismiss();
                DownloadService.getBinder().cancelDownload();
            }
        });
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
