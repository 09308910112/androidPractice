package com.lpc.designpattern.decorator.first;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/16.
 */
public class LPCBoy extends Boy {

    @Override
    String wear() {
        return  "LPCBoy:牛仔裤";
    }

    @Override
    String take() {
        return "LPCBoy:一本PMP书籍";
    }
}
