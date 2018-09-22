package com.lanyou.lpc.jsjavacall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public WebView webView;
    public TextView appTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    
    
    private void initData() {
        javaCallJs();
    }

    private void javaCallJs() {
        appTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:wave()");
            }
        });
    }
    private void initView() {
        appTitle = findViewById(R.id.app_title);
        initWebView();
    }

    private void initWebView() {
        webView = findViewById(R.id.wb);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/demo.html");
        webView.addJavascriptInterface(new JsCallJava() {
            @JavascriptInterface
            @Override
            public void onCallBack(String title) {
                Toast.makeText(MainActivity.this,title,Toast.LENGTH_LONG).show();
            }
        },"lpc");
    }
    public interface JsCallJava{
         void onCallBack(String title);

    }
}
