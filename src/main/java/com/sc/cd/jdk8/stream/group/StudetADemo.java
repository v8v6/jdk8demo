package com.sc.cd.jdk8.stream.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-16 18:35
 */
public class StudetADemo {

    public static void main(String[] args) {
        List<StudentA> list1= Arrays.asList(
                new StudentA(1,"one","zhao",false),
                new StudentA(2,"one2","qian",false),
                new StudentA(3,"two1","sun",false),
                new StudentA(3,"two2","sun",false));

        Map<Boolean, List<StudentA>> collect = list1.stream()
                .collect(Collectors.partitioningBy(StudentA::getFail));
        System.out.println(collect);
    }
}
