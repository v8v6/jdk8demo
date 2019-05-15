package com.sc.cd.jdk8.stream.mergestream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 17:09
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("I am a boy");
        list.add("I love the girl");
        list.add("But the girl loves another girl");

        List<String> collect = list.stream().map(str -> str.split(" ")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(collect);

    }
}
