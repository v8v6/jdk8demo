package com.sc.cd.jdk8.stream.limit;

import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 17:09
 */
public class Test {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("1", "", "2", "3", "4", "", "7");
        stringStream.filter(str -> !str.isEmpty()).limit(3).forEach(System.out::println);
    }
}
