package com.sc.cd.action.five;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-24 10:31
 */
public class Demo1 {

    public static void main(String[] args) {
        // range和rangeClosed。这两个方法都是第一个参数接受起始值，第二个参数接受结束值。但
        // range是不包含结束值的，而rangeClosed则包含结束值
        IntStream range = IntStream.range(1, 100);
        System.out.println(range.count());
        range = IntStream.rangeClosed(1, 100);
        System.out.println(range.count());


        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();
        System.out.println(emptyStream);

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }
}
