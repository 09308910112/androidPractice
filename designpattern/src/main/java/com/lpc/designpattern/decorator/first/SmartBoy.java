package com.lpc.designpattern.decorator.first;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/16.
 */
public class SmartBoy extends Boy {
    Boy boy;

    public SmartBoy(Boy boy) {
        this.boy = boy;
    }

    @Override
    String wear() {
        return boy.wear() + ",SmartBoy:穿着小拖鞋";
    }

    @Override
    String take() {
        return boy.take() + ",SmartBoy:左手拿着一本书";
    }
}
