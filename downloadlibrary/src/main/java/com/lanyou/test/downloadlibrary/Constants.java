package com.lanyou.test.downloadlibrary;

import android.os.Environment;

import java.io.File;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/11.
 */
public class Constants {

    public static final String TAG = "download_lib";
    /**
     * 下载成功
     */
    public static final int DOWNLOAD_TYPE_SUCCESS = 0;
    /**
     * 下载失败
     */
    public static final int DOWNLOAD_TYPE_FAILED = 1;
    /**
     * 下载停止
     */
    public static final int DOWNLOAD_TYPE_PAUSED = 2;
    /**
     * 下载取消
     */
    public static final int DOWNLOAD_TYPE_CANCELED = 3;
    /**
     * 下载正在进行
     */
    public static final int DOWNLOAD_TYPE_DOWNLOAD = 4;


    /**
     * 获取下载的本地apk路径
     *
     * @return
     */
    public static File getLocalDownloadApkFile() {
        String downloadUrl = DownLoadUtils.downloadUrl;
        if (downloadUrl == null) {
            return null;
        }
        String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
        String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        return new File(directory + "/" + fileName);
    }

    /**
     * 获取下载的状态值
     *
     * @param status
     * @return
     */
    public static String getDownloadStatusString(int status) {
        String retValue = null;
        if (status == DOWNLOAD_TYPE_SUCCESS) {
            retValue = "安装";
        } else if (status == DOWNLOAD_TYPE_FAILED) {
            retValue = "确定";
        } else if (status == DOWNLOAD_TYPE_PAUSED) {
            retValue = "继续下载";
        } else if (status == DOWNLOAD_TYPE_CANCELED) {
            retValue = "确定";
        } else if (status == DOWNLOAD_TYPE_DOWNLOAD) {
            retValue = "暂停";
        }
        return retValue;
    }

    public static String getDownloadTitle(int status) {
        String retValue = null;
        if (status == DOWNLOAD_TYPE_SUCCESS) {
            retValue = "最新App下载成功";
        } else if (status == DOWNLOAD_TYPE_FAILED) {
            retValue = "下载失败";
        } else if (status == DOWNLOAD_TYPE_PAUSED) {
            retValue = "下载暂停";
        } else if (status == DOWNLOAD_TYPE_CANCELED) {
            retValue = "下载取消";
        } else if (status == DOWNLOAD_TYPE_DOWNLOAD) {
            retValue = "正在下载";
        }
        return retValue;
    }
}
