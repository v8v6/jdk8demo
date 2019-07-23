package com.sc.cd.jdk8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorDemo {


    public static <T> List<Integer> operator(List<T> list, IntBinaryOperator intBinaryOperator) {
        List<Integer> l = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            l.add(Integer.valueOf(intBinaryOperator.applyAsInt(sum,i)));
        }
        return l;
    }

    public static void main(String[] args) {
        List<Integer> sum = operator(Arrays.asList(1,2,3,4,5,6), (a, b) -> a + b);
        System.out.println(sum);
    }
}
