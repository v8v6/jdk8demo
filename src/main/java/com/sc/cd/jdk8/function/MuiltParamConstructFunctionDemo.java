package com.sc.cd.jdk8.function;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class MuiltParamConstructFunctionDemo {

    public static void main(String[] args) {
        // MuiltParamConstructFunction<String, String, Double, Boolean, Car> function = Car::new;
        // 顺序
        Comparator<Car> c = Comparator.comparing(Car::getWeight);
        // 倒序
        c = Comparator.comparing(Car::getWeight).reversed();

        // 多组合排序规则
        c = Comparator.comparing(Car::getWeight)
                .reversed()
                .thenComparing(Car::getIsNew).thenComparing(Car::getLimit);

        // car 是新的
        Predicate<Car> redApple = Car::getIsNew;
        // car 不是新的
        Predicate<Car> notRedApple = redApple.negate();
        // a.or(b).and(c)可以看作(a || b) && c
        notRedApple.or(car -> car.getLimit() > 10)
                .and(car -> car.getHeight() > 1.5);


        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        // 先f 再g
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);
        System.out.println(result);

        // 先g 再f
        h = f.compose(g);
        result = h.apply(1);
        System.out.println(result);



    }
}
