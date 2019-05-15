package com.sc.cd.jdk8.stream.collectorsAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-20 16:04
 */

public class Demo {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        Optional.ofNullable(menu.stream().collect(Collectors.
                groupingBy(Dish::getType,
                        Collectors.averagingInt(Dish::getCalories))))
                .ifPresent(System.out::println);
        System.out.println("==========================================================================================");

        //本来返回有个map
        Map<Dish.Type, Double> map = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        System.out.println(map);
        //先在要返回一个treemap
        Map<Dish.Type, Double> collectq = menu.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingInt(Dish::getCalories)));
        System.out.println(collectq);
        Optional.of(map.getClass()).ifPresent(System.out::println);
        Optional.of(collectq.getClass()).ifPresent(System.out::println);
        System.out.println("==========================================================================================");


        TreeMap<String, Double> treeMap = Maps.newTreeMap();

        treeMap.put("OTHER",387.5);
        treeMap.put("MEAT",633.33333);
        treeMap.put("FISH",375.0);
        System.out.println(treeMap);


        String collect = menu.stream().collect(collectingAndThen(Collectors.groupingBy(Dish::getType), a -> "xxxx" + a));
        System.out.println(collect);
        testcollectingAndThen(menu);

        testSummarizingInt(menu);










        /*

        testAveragingDouble(menu);


        try{
            List<Dish> collect1 = menu.stream().filter
                    (d -> d.getType().equals(Dish.Type.OTHER)).
                    collect(collectingAndThen(toList(),
                            Collections::unmodifiableList));
            System.out.println(collect1);
            collect1.add(new Dish("", false, 100, Dish.Type.OTHER));

            System.out.println(collect1);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }



        List<Dish> collect12 = menu.stream().filter
                (d -> d.getType().equals(Dish.Type.OTHER)).collect(toList());
        System.out.println("==========================================================================================");

        System.out.println(collect12);

        List<Dish> collect = menu.stream().filter(d -> d.getType().equals(Dish.Type.OTHER)).collect(toList());

        collect.add(new Dish("", false, 100, Dish.Type.OTHER));
        System.out.println(collect);

        System.out.println("===============");
        testcollectingAndThen(menu);

        testAveragingDouble1(menu);
        */
    }


    private static void testSummarizingInt(List<Dish> menu) {
        System.out.println("testSummarizingInt");
        IntSummaryStatistics cl = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.ofNullable(cl).ifPresent(System.out::println);
    }



    private static void testcollectingAndThen(List<Dish> menu) {
        System.out.println("testcollectingAndThen");
        Optional.ofNullable(menu.stream().collect(Collectors.
                collectingAndThen(averagingInt(Dish::getCalories),
                        a -> "CAlumniate" + a)))
                .ifPresent(System.out::println);

    }

    private static void testAveragingDouble(List<Dish> menu) {
        System.out.println("testAveragingDouble");
        Double collect = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        Optional.ofNullable(collect)
                .ifPresent(System.out::println);
    }


    private static void testAveragingDouble1(List<Dish> menu) {
        System.out.println("testAveragingDouble");
        String collect = menu.stream().collect(collectingAndThen(Collectors.averagingDouble(Dish::getCalories), a -> "then:" + a));
        Optional.ofNullable(collect)
                .ifPresent(System.out::println);
    }
}
