package com.sc.cd.jdk8.stream.distinct;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 17:09
 */
public class Test {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("1", "", "2", "9", "", "3", "4", "2", "7", "", "9");
        List<String> collect = stringStream
                .filter(str -> !str.isEmpty())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect);

        ArrayList<Car> cars = Lists.newArrayList(new Car("1", "2" , 2d),
                new Car("2", "2" , 2d),
                new Car("3", "2" , 2d));
        // distinct() equals & hashCode方法确定重复
        List<Car> carList = cars.stream()
                .filter(car -> Objects.equals("2", car.getCode()))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(carList);

        List<Cat> cats = Lists.newArrayList(new Cat("1", "2" , 2d),
                new Cat("2", "2" , 2d),
                new Cat("3", "2" , 2d));
        // distinct() equals & hashCode方法确定重复
        List<Cat> catList = cats.stream()
                .filter(cat -> Objects.equals("2", cat.getCode()))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(catList);

    }
}
