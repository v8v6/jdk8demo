package com.sc.cd.jdk8.stream.sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-20 14:22
 */
public class Test {

    public static void main(String[] args) {
        List<User> list = Lists.newArrayList(new User("Y", "YY"), new User("A", "AA"), new User(null, "CC"));
        list.stream().forEach(System.out::println);
        System.out.println("------------------------------");

        List<User> nList = list.stream().sorted(
                Comparator.comparing(User::getCode, Comparator.nullsLast(String::compareTo)))

                .collect(Collectors.toList());
        nList.stream().forEach(System.out::println);




    }
}
