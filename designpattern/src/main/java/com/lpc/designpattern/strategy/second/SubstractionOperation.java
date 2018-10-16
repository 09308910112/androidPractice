package com.lpc.designpattern.strategy.second;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/16.
 */
public class SubstractionOperation extends StrategyOperation {
    @Override
    double operation(int num1, int num2) {
        return num1 - num2;
    }
}
