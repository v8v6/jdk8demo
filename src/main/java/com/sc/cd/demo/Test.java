package com.sc.cd.demo;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {


        List<String> list = Lists.newArrayList("not", "add", "dog", "acid", "add", "elf", "gap", "cat", "rat");
        List<String> a = foo(list, "a");
        System.out.println(a);

        List<Integer> temps = Lists.newArrayList(2, 3, 3, 5, 5, 5, 11, 6, 11);
        System.out.println(order(temps));
        temps = Lists.newArrayList(3, 4, 4, 1, 2, 2, 2);
        System.out.println(order(temps));
        temps = Lists.newArrayList(2, 5, 3, 9, 7);
        boolean isExist = f(temps, 12);
        System.out.println(isExist);


        try {
            get();
        } catch (Exception ex) {
            System.out.println("Catch");
            return;
        } finally {
            System.out.println("Finally");
        }
        System.out.println("Exit");
    }

    public static void get() {
        System.out.println("Get");
        throw new NullPointerException();
    }

    private static boolean f(List<Integer> temps, int targetNum) {
        if (Objects.isNull(temps) || Objects.isNull(targetNum) || temps.isEmpty()) {
            return false;
        }
        return temps.stream()
                .map(t -> targetNum - t)
                .anyMatch(t -> temps.contains(t));
    }

    private static List<Integer> order(List<Integer> temps) {
        if (Objects.isNull(temps)) {
            return Collections.emptyList();
        }

        return temps.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    public static List<String> foo(List<String> list, String str) {
        if (StringUtils.isBlank(str)) {
            return Collections.emptyList();
        }
        return list.stream()
                .filter(StringUtils::isNotBlank)
                .filter(s -> s.contains(str))
                .map(s -> StringUtils.reverse(s))
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
    }


}
