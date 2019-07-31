package com.sc.cd.jdk8.stream.box;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.sc.cd.jdk8.stream.distinct.Cat;

public class BoxDemo {
    public static void main(String[] args) {
        List<Cat> cats = Lists.newArrayList(new Cat("1", "2" , 2d),
                new Cat("2", "2" , 2d),
                new Cat("3", "2" , 2d));
        double reduce = cats.stream()
                .mapToDouble(cat -> cat.getLimit())
                .reduce(0, Double::sum);
        System.out.println(reduce);

        reduce = cats.stream()
                .map(cat -> cat.getLimit())
                .reduce(0d, Double::sum);

        DoubleStream doubleStream = cats.stream().mapToDouble(Cat::getLimit);
        // 数值范围装􏰣箱成为一个一般流
        Stream<Double> boxed = doubleStream.boxed();

        OptionalDouble maxLimit = cats.stream()
                .mapToDouble(Cat::getLimit)
                .max();
        double limit = maxLimit.orElse(1D);
        Stream<String> emptyStream = Stream.empty();
        List<String> stringList = emptyStream.map(s -> s + "1").collect(Collectors.toList());
        System.out.println(stringList.size());


        long howManyDishes = cats.stream().collect(Collectors.counting());
        howManyDishes = cats.stream().count();



    }
}
