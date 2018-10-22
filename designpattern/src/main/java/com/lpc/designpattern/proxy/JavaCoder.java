package com.lpc.designpattern.proxy;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/22.
 */
public class JavaCoder implements ICoder {
    @Override
    public String completeDemand() {
        return "Java 编程";
    }
}
