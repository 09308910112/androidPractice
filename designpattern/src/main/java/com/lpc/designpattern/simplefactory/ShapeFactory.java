package com.lpc.designpattern.simplefactory;

/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/10/20.
 */
public class ShapeFactory {
    public static final String TYPE_CIRCLE = "circle";
    public static final String TYPE_RECTANGE = "rectange";

    public Shape createShape(String type) {
        if (TYPE_CIRCLE.equals(type)) {
            return new Circle();
        } else if (TYPE_RECTANGE.equals(type)) {
            return new Rectange();
        }
        return null;
    }
}
