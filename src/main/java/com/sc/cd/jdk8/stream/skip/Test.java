package com.sc.cd.jdk8.stream.skip;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .skip(3)
                //.limit(2)
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}
