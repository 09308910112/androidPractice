package com.lpc.designpattern.proxy;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/22.
 */
public class ProxyCoder implements ICoder {
    ICoder coder;
    public ProxyCoder(ICoder coder){
        this.coder = coder;
    }
    @Override
    public String completeDemand() {
        return "下面是经过我代理的："+coder.completeDemand();
    }
}
