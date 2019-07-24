package com.sc.cd.jdk8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorDemo {


    public static <T> int operator(List<T> list, IntBinaryOperator intBinaryOperator) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = intBinaryOperator.applyAsInt(sum,(Integer)list.get(i));
        }
        return sum;
    }

    public static void main(String[] args) {
        IntBinaryOperator intBinaryOperator = (a, b) -> a + b;
        System.out.println(intBinaryOperator.applyAsInt(10, 60));

        int sum = operator(Arrays.asList(1,2,3,4,5,6), (a, b) -> a + b);
        System.out.println(sum);
    }
}
