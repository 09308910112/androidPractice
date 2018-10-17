package com.lpc.designpattern.decorator.second;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/17.
 */
public abstract class ShapeDecorator implements Shape {
    Shape shapeDecorator;

    public ShapeDecorator(Shape shapeDecorator) {
        this.shapeDecorator = shapeDecorator;
    }

   /* @Override
    public String draw() {
        return shapeDecorator.draw();
    }*/
}
