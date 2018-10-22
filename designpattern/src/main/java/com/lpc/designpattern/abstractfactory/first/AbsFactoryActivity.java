package com.lpc.designpattern.abstractfactory.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lpc.designpattern.R;


public class AbsFactoryActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_factory);
        tvResult = findViewById(R.id.tv_result);

        IFactory factory = new Factory();
        String pa = factory.createProductA().showProduct();
        String pb = factory.createProductB().showProduct();

        tvResult.setText(pa + "\n" + pb);
        ;
    }
}
