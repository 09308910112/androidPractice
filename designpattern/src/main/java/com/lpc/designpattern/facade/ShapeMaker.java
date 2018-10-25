package com.lpc.designpattern.facade;

/**
 * Created by lpc on 2018/10/25.
 */
public class ShapeMaker {
    Circle circle;
    Rectangle rectangle;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    public String drawCircle() {
        return circle.draw();
    }

    public String drawRectangle() {
        return rectangle.draw();
    }
}
