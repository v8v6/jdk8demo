package com.sc.cd.jdk8.stream.anymatch;

import java.lang.reflect.Array;
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
        boolean b = strs.stream().anyMatch(str -> str.endsWith("2"));
        System.out.println(b);
        b = strs.stream().anyMatch(str -> str.endsWith("20"));
        System.out.println(b);
    }
}
