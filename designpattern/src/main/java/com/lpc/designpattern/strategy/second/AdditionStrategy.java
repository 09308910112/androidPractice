package com.lpc.designpattern.strategy.second;

/**
 * Created by lpc on 2018/10/16.
 */
public class AdditionStrategy extends StrategyOperation {
    @Override
    double operation(int num1, int num2) {
        return num1 + num2;
    }
}
