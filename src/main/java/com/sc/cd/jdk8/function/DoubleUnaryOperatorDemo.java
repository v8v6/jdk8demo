package com.sc.cd.jdk8.function;

import java.util.function.DoubleUnaryOperator;

public class DoubleUnaryOperatorDemo {
    public static void main(String[] args) {
        DoubleUnaryOperator doubleUnaryOperator = x -> x+1;
        double applyAsDouble = doubleUnaryOperator.applyAsDouble(1d);
        System.out.println(applyAsDouble);
    }
}
