package com.lpc.designpattern.proxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lpc.designpattern.R;


public class ProxyActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);
        tvResult = findViewById(R.id.tv_result);

        ICoder coder = new ProxyCoder(new JavaCoder());
        tvResult.setText(coder.completeDemand());;
    }
}
