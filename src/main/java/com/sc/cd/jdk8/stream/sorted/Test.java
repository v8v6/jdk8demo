package com.sc.cd.jdk8.stream.sorted;

import java.util.Comparator;
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
        // 降序
        stringStream.filter(str -> !str.isEmpty()).sorted(Comparator.reverseOrder()).limit(5).forEach(System.out::println);
        // 升序
        stringStream.filter(str -> !str.isEmpty()).sorted().limit(5).forEach(System.out::println);
    }
}
