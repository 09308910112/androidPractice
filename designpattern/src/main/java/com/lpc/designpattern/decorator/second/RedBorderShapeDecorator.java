package com.lpc.designpattern.decorator.second;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/17.
 */
public class RedBorderShapeDecorator extends ShapeDecorator {

    public RedBorderShapeDecorator(Shape shapeDecorator) {
        super(shapeDecorator);
    }

    @Override
    public String draw() {
        return shapeDecorator.draw()+setRedBorder();
    }

    public String setRedBorder() {
        return ",用红红点缀一下边框";
    }
}
