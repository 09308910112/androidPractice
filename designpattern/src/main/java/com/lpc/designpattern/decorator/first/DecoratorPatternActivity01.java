package com.lpc.designpattern.decorator.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lpc.designpattern.R;

public class DecoratorPatternActivity01 extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator_pattern_01);
        initView();
    }

    private void initView() {
        tvResult = findViewById(R.id.tv_result);
        Boy b = /*new SmartBoy(*/new BeautyBoy(new LPCBoy())/*)*/;
        tvResult.setText(b.wear() + "\n" + b.take());
    }

}
