package com.lpc.designpattern.strategy.second;

/**
 * Created by lpc on 2018/10/16.
 */
public class ContextStrategy {
    StrategyOperation operation;

    public ContextStrategy(StrategyOperation operation) {
        this.operation = operation;
    }

    public double executeStrategy(int num1, int num2) {
        return operation.operation(num1, num2);
    }
}
