package com.lanyou.lpc.x5test;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        X5WebView wv = findViewById(R.id.webview);
       wv.setHorizontalScrollBarEnabled(false);
        wv.setVerticalScrollBarEnabled(false);
        // 自适应
        // mWebView.getSettings().setUseWideViewPort(true);
        // mWebView.getSettings().setLoadWithOverviewMode(true);
        com.tencent.smtt.sdk.WebSettings webSettings = wv.getSettings();

        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptEnabled(true);// js支持
        webSettings.setSupportZoom(true);// 支持缩放
        webSettings.setBuiltInZoomControls(false);// 隐藏缩放按钮
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDefaultTextEncodingName("UTF-8");
        // 需要设置这两项JS才正常
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        wv.loadUrl("https://vit.venucia.com/iovapp/flow_package_list?userId=11748&sign=f87abe90dbbe4848c67304a5b6cfdde9&timestamp=1529404604");

    }
}
