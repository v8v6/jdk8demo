package com.sc.cd.jdk8.stream.nonematch;

import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 17:09
 */
public class Test {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("1", "", "2", "9", "", "3", "4", "2", "7", "", "9");
        boolean b = strs.stream().noneMatch(str -> str.endsWith("5"));
        System.out.println(b);
        b = strs.stream().noneMatch(str -> str.endsWith("2"));
        System.out.println(b);
    }
}
