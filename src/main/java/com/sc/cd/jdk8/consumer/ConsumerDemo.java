package com.sc.cd.jdk8.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.sc.cd.jdk8.predicate.Dish;

public class ConsumerDemo {

    public static void main(String[] args) {
        forEach(Arrays.asList(1,2,3,4,5), i -> System.out.println(i));

        Consumer<Dish> consumer = dish -> {
            System.out.println(dish);
            System.out.println(dish);
        };

        forEach(Arrays.asList(new Dish(),new Dish()), consumer);
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }
}
