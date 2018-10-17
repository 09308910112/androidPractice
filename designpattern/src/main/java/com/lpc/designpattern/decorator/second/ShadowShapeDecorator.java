package com.lpc.designpattern.decorator.second;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/17.
 */
public class ShadowShapeDecorator extends ShapeDecorator {

    public ShadowShapeDecorator(Shape shapeDecorator) {
        super(shapeDecorator);
    }

    @Override
    public String draw() {
        return shapeDecorator.draw() + setShadow();
    }

    public String setShadow() {
        return ",使用了阴影";
    }
}
