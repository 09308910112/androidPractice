package com.lpc.designpattern.decorator.first;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/16.
 */
public class BeautyBoy extends Boy {
    Boy boy;

    BeautyBoy(Boy boy) {
        this.boy = boy;
    }

    @Override
    String wear() {
        return boy.wear() + ",BeautyBoy:穿着西装" ;
    }

    @Override
    String take() {
        return boy.take() + ",BeautyBoy:手里拿着鲜花" ;
    }
}
