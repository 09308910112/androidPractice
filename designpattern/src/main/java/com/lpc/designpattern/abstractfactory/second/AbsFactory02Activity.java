package com.lpc.designpattern.abstractfactory.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lpc.designpattern.R;


public class AbsFactory02Activity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_factory);
        tvResult = findViewById(R.id.tv_result);

        IFactory factory = new HuaWeiFactory();
        factory.createMobileProduct().showProduct();
        factory.createWatchProduct().showProduct();

        IFactory factory02 = new AppleFactory();
        factory02.createMobileProduct().showProduct();
        factory02.createWatchProduct().showProduct();

        tvResult.setText("请看log日志");
    }
}
