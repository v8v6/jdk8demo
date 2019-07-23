package com.sc.cd.jdk8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.google.common.collect.Lists;

public class FunctionDemo {

    public static void main(String[] args) {
        List<Integer> integers = map(Lists.newArrayList("1", "2", "222"), s -> s.length());
        System.out.println(integers);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }
}
