package com.sc.cd.jdk8.stream.sorted;

import java.util.Comparator;
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
        List<String> list = Stream.of("1", "", "2", "9", "", "3", "4", "2", "7", "", "9")
                .collect(Collectors.toList());
        // 降序
        list.stream().sorted(Comparator.reverseOrder()).limit(5).forEach(System.out::println);
        System.out.println("********");
        // 升序
        list.stream().filter(str -> !str.isEmpty()).sorted().limit(5).forEach(System.out::println);
        System.out.println("********");
        list.stream().filter(str -> !str.isEmpty()).limit(5).forEach(System.out::println);
        System.out.println("********");

        System.out.println(0 != 0L);

        System.out.println(4 & 4);
        System.out.println(8 & 4);
        System.out.println(12 & 8);
    }
}
