package com.lpc.designpattern.facade;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lpc.designpattern.R;
import com.lpc.designpattern.proxy.ICoder;
import com.lpc.designpattern.proxy.JavaCoder;
import com.lpc.designpattern.proxy.ProxyCoder;


public class FacadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);
        TextView tvResult = findViewById(R.id.tv_result);
        ShapeMaker maker = new ShapeMaker();
        tvResult.setText(maker.drawCircle()+"\n"+maker.drawRectangle());
    }
}
