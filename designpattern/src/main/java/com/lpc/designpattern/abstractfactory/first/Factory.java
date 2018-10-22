package com.lpc.designpattern.abstractfactory.first;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/22.
 */
public class Factory implements IFactory {
    @Override
    public IProductA createProductA() {
        return new ProductA();
    }

    @Override
    public IProductB createProductB() {
        return new ProductB();
    }
}
