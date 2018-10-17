package com.lpc.designpattern.decorator.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lpc.designpattern.R;
import com.lpc.designpattern.decorator.first.BeautyBoy;
import com.lpc.designpattern.decorator.first.Boy;
import com.lpc.designpattern.decorator.first.LPCBoy;

public class DecoratorPatternActivity02 extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator_pattern_01);
        initView();
    }

    private void initView() {
        tvResult = findViewById(R.id.tv_result);
       Shape shape =  new RedBorderShapeDecorator(new CircleShape());
       Shape shape1 = new ShadowShapeDecorator(new RectangeShape());
        tvResult.setText(shape.draw()+"\n"+shape1.draw());
    }

}
