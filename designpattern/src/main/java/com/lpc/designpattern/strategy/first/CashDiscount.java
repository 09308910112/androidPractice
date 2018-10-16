package com.lpc.designpattern.strategy.first;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/13.
 */
public class CashDiscount implements CashSuper {


    @Override
    public double acceptCash(double money) {
        return money * 0.8;
    }
}
