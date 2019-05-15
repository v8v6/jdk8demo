package com.sc.cd.jdk8.stream.count;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 17:09
 */
public class Test {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("1", "", "2", "9", "", "3", "4", "2", "7", "", "9");
        long startTime = System.currentTimeMillis();
        long count = strs.stream().filter(str -> !str.isEmpty()).count();
        long useTime = System.currentTimeMillis() - startTime;
        System.out.println(useTime);
        System.out.println(count);
        startTime = System.currentTimeMillis();
        count = strs.parallelStream().filter(str -> !str.isEmpty()).count();
        useTime = System.currentTimeMillis() - startTime;
        System.out.println(useTime);
        System.out.println(count);

        Stream<String> stringStream = Stream.of("1", "", "2", "9", "", "3", "4", "2", "7", "", "9");
        startTime = System.currentTimeMillis();
        count = stringStream.parallel().filter(str -> !str.isEmpty()).count();
        useTime = System.currentTimeMillis() - startTime;
        System.out.println(useTime);
        System.out.println(count);


    }
}
