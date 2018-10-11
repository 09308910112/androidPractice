package com.lanyou.test.downloadlibrary;

import android.os.AsyncTask;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 *
 * @author lpc
 * @date 2018/9/17
 */
public class DownloadTask extends AsyncTask<String, Integer, Integer> {

    private boolean isCanceled = false;
    private boolean isPause = false;
    int lastProgress = 0;

    private DownloadListener listener;

    public DownloadTask(DownloadListener listener) {
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream is = null;
        RandomAccessFile saveFile = null;
        File file = null;
        try {
            long downloadedLength = 0;
            String downloadUrl = params[0];
            file = Constants.getLocalDownloadApkFile();
            if (file.exists()) {
                downloadedLength = file.length();
            }
            long contentLength = getConentLength(downloadUrl);
            if (contentLength == 0) {
                return Constants.DOWNLOAD_TYPE_FAILED;
            } else if (contentLength == downloadedLength) {
                return Constants.DOWNLOAD_TYPE_SUCCESS;
            }
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE", "bytes=" + downloadedLength + "-")
                    .url(downloadUrl)
                    .build();
            Response response = client.newCall(request).execute();
            if (response != null) {
                is = response.body().byteStream();
                saveFile = new RandomAccessFile(file, "rw");
                Log.e("download", "save:" + file.getPath().toString());
                saveFile.seek(downloadedLength);
                byte[] b = new byte[1024];
                int len;
                int total = 0;
                while ((len = is.read(b)) != -1) {
                    if (isCanceled) {
                        return Constants.DOWNLOAD_TYPE_CANCELED;
                    } else if (isPause) {
                        return Constants.DOWNLOAD_TYPE_PAUSED;
                    } else {
                        total += len;
                    }
                    saveFile.write(b, 0, len);
                    int progress = (int) ((total + downloadedLength) * 100 / contentLength);
                    publishProgress(progress);
                }
            }
            response.body().close();
            return Constants.DOWNLOAD_TYPE_SUCCESS;
        } catch (Exception e) {
            Log.e("download", "下载出错");
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (saveFile != null) {
                    saveFile.close();
                }
                if (isCanceled && file != null) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Constants.DOWNLOAD_TYPE_FAILED;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if (progress > lastProgress) {
            listener.onProgress(progress);
            lastProgress = progress;
        }
    }

    @Override
    protected void onPostExecute(Integer downLoadStatus) {
        switch (downLoadStatus) {
            case Constants.DOWNLOAD_TYPE_SUCCESS:
                listener.onSuccess();
                break;
            case Constants.DOWNLOAD_TYPE_FAILED:
                listener.onFailed();
                break;
            case Constants.DOWNLOAD_TYPE_PAUSED:
                listener.onPaused();
                break;
            case Constants.DOWNLOAD_TYPE_CANCELED:
                listener.onCanceled();
                break;
            default:
                break;
        }
    }

    public void pausedDownLoad() {
        isPause = true;
    }

    public void cancelDownLoad() {
        isCanceled = true;
    }

    /**
     * 获取下载文件的内容长度
     *
     * @param downloadUrl 下载的Url
     */
    private long getConentLength(String downloadUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        Response response = client.newCall(request).execute();
        if (response != null && response.isSuccessful()) {
            long contentLength = response.body().contentLength();
            response.body().close();
            return contentLength;
        }
        return 0;
    }


}
