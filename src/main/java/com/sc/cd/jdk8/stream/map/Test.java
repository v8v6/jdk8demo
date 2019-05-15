package com.sc.cd.jdk8.stream.map;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sc.cd.jdk8.stream.filter.Person;


/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 16:36
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> collect = integers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(collect);
        List<String> s = Arrays.asList("1", "a");

        Optional<List<String>> optional = Optional.ofNullable(s);
        try {
            optional.ifPresent(l -> {
                l.stream().forEach(e -> {

                    Integer.valueOf(e);

                });
            });
        } catch (Exception ex) {
            log.error("test error:{}",ex.getMessage(),ex);
            // throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
