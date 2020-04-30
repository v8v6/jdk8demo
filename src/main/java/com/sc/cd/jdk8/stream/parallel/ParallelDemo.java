package com.sc.cd.jdk8.stream.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sc.cd.action.six.Dish;

public class ParallelDemo {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        System.out.println(System.nanoTime());
        Integer sum = menu.stream()
                .parallel()
                .map(Dish::getCalories)
                // 并行流变顺序流 改变stream里面并行的标志 为false
                .sequential()
                .collect(Collectors.reducing(0,Integer::sum));
        System.out.println(sum);
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        sum = menu.stream()
                .map(Dish::getCalories)
                .collect(Collectors.reducing(0,Integer::sum));
        System.out.println(sum);
        System.out.println(System.nanoTime());
        int sums = menu.stream()
                .mapToInt(Dish::getCalories).sum();
        System.out.println(sums);
        System.out.println(System.nanoTime());
        int collect = menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));
    }
}
