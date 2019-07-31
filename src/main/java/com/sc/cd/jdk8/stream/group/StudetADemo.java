package com.sc.cd.jdk8.stream.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import com.sc.cd.action.six.Dish;
import com.sc.cd.action.six.Dish.CaloricLevel;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

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
                new StudentA(2,"one","qian",false),
                new StudentA(3,"two1","sun",false),
                new StudentA(3,"two2","sun",false));

        Map<Boolean, List<StudentA>> collect = list1.stream()
                .collect(partitioningBy(StudentA::getFail));
        System.out.println(collect);

        System.out.println("======================");

        // 单条件组
        // 􏹳普通的单参数groupingBy(f)(其中f是分类函数)实际上是groupingBy(f, toList())的简便写法
        Map<String, List<StudentA>> listMap = list1.stream()
                .collect(groupingBy(StudentA::getGroupId));
        System.out.println(listMap);

        System.out.println("======================");

        // 多条件组
        Map<String, Map<String, List<StudentA>>> stringMapMap = list1.stream()
                .collect(groupingBy(StudentA::getGroupId, groupingBy(StudentA::getName)));
        System.out.println(stringMapMap);

        System.out.println("=================");

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

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);
        System.out.println("+++++++++++++++");

        Map<Dish.Type, Long> typeLongMap = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println(typeLongMap);
        System.out.println("=================");

        Map<Dish.Type, Dish> caloricByType =
                menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(caloricByType);
        System.out.println("-----------------");

        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);

        System.out.println("==============");

        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> { if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                                else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                                else return Dish.CaloricLevel.FAT; },
                                toSet() )));

        System.out.println(caloricLevelsByType);
        System.out.println("-----------------");

        caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                else return CaloricLevel.FAT; },
                                toCollection(HashSet::new) )));

        System.out.println(caloricLevelsByType);
        System.out.println("=================");

        Collection<Integer> lists = IntStream.rangeClosed(2, 10)
                .boxed()
                .collect(toCollection(ArrayList::new));


        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream()
                        .collect(partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);
    }
}
