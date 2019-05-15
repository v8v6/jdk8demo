package com.sc.cd.action.three;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-24 15:42
 */
public class Demo {
    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        boolean test = nonEmptyStringPredicate.test("");
        System.out.println(test);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        forEach(integers,System.out::println);

    }

    public static <T> void forEach(List<T> list, Consumer<T> c){

        for(T i: list){
            c.accept(i);
        }
    }
}
