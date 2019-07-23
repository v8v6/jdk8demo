package com.sc.cd.jdk8.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class PredicateDemo {

    public static void main(String[] args) {
        List<String> listOfStrings = Lists.newArrayList("a", "", "b", "c");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(nonEmpty);

        Predicate<Dish> p = dish -> dish.getCalories() > 0;
        List<Dish> list = Lists.newArrayList();
        list.stream().filter(p).collect(Collectors.toList());
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
