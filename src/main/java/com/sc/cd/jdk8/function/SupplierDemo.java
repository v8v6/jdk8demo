package com.sc.cd.jdk8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import com.google.common.collect.Lists;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "1234";
        String s = supplier.get();
        System.out.println(s);

        List<String> str = Arrays.asList("a","b","A","B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);

        Function<String, Integer> stringToInteger = s1 -> Integer.parseInt(s1);
        stringToInteger = Integer::parseInt;

        Integer integer = stringToInteger.apply("1");
        System.out.println(integer);

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        contains = List::contains;
        boolean test = contains.test(Lists.newArrayList("1", "42", "34", "4"), "4");
        System.out.println(test);
    }
}
