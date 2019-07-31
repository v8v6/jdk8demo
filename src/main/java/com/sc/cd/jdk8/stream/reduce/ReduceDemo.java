package com.sc.cd.jdk8.stream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import com.sc.cd.jdk8.stream.distinct.Cat;

import static java.util.stream.Collectors.reducing;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 8, 10);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);
        sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        List<Cat> cats = Lists.newArrayList(new Cat("1", "2" , 2d),
                new Cat("2", "2" , 2.4d),
                new Cat("3", "2" , 1.9d));

        int count = cats.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(count);
        count = cats.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);
        System.out.println(count);
        long limit = cats.stream().count();
        System.out.println(limit);

        double totalCalories = cats.stream().collect(reducing(
                0d, Cat::getLimit, (i, j) -> i + j));

        // TODO
        Optional<Cat> mostCalorieDish =
                cats.stream().collect(reducing(
                        (d1, d2) -> d1.getLimit() > d2.getLimit() ? d1 : d2));
    }
}
