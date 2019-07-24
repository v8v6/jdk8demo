package com.sc.cd.jdk8.stream.flatmap;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

import static java.util.stream.Collectors.toList;

public class FlatMapDemo {

    public static void main(String[] args) {
        List<String> words = Lists.newArrayList("Hello", "World");
        List<String[]> list = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        System.out.println(list);

        List<String> stringList = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(stringList);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        System.out.println(pairs);

        pairs = numbers1.stream()
                .flatMap(i ->
                        numbers2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})
                )
                .collect(toList());
        System.out.println(pairs);
    }
}
