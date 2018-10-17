package com.lpc.designpattern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lpc.designpattern.decorator.first.DecoratorPatternActivity01;
import com.lpc.designpattern.decorator.second.DecoratorPatternActivity02;
import com.lpc.designpattern.strategy.second.StrategyPatternActivity02;
import com.lpc.designpattern.strategy.first.StrategyPatternActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 策略设计模式
     */
    public void strategy(View view) {
        startActivity(new Intent(this, StrategyPatternActivity.class));
    }

    public void strategy02(View view) {
        startActivity(new Intent(this, StrategyPatternActivity02.class));
    }

    public void decorate01(View view) {
        startActivity(new Intent(this, DecoratorPatternActivity01.class));
    }
    public void decorate02(View view) {
        startActivity(new Intent(this, DecoratorPatternActivity02.class));
    }

}
