package com.lpc.designpattern.strategy.first;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/13.
 */
public class CashReturn implements CashSuper {

    @Override
    public double acceptCash(double money) {
        if (money > 100) {
            return money - 20;
        } else if (money > 200) {
            return money - 25;
        }
        return money - 50;
    }
}
