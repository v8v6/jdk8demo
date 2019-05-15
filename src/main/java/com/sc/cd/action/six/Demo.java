package com.sc.cd.action.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sc.cd.action.six.Dish.Type;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;


/**
 * @author junxi.chen
 * @create 2018-12-24 10:53
 */
public class Demo {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH));

        /*long howManyDishes = menu.stream().collect(counting());
        System.out.println(howManyDishes);
        howManyDishes = menu.stream().count();
        System.out.println(howManyDishes);

        Comparator<Dish> dishCaloriesComparator =
                comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));

        int sum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);

        System.out.println(mostCalorieDish);

        IntSummaryStatistics collect = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(collect);


        String s = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(s);

        Integer collect1 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(collect1);

        String shortMenu = menu.stream().map(Dish::getName)
                .collect(reducing((s1, s2) -> s1 + s2)).get();
        System.out.println(shortMenu);


        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }));
        System.out.println(dishesByCaloricLevel);


        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                                    else return Dish.CaloricLevel.FAT;
                                })
                        )
                );

        System.out.println(dishesByTypeCaloricLevel);


        //menu = new ArrayList<>();
        Stream<Dish> stream = menu.stream();
        System.out.println(stream);

        menu.stream().collect(groupingBy(Dish::getCalories));

        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);

        Map<Type, Optional<Dish>> collect2 = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(collect2);

        Map<Dish.Type, Dish> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));
        System.out.println(mostCaloricByType);

        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));

        System.out.println(totalCaloriesByType);

        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                    dish -> {
                                        if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                                        else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                                        else return Dish.CaloricLevel.FAT;
                                    },
                                    toSet()
                                )
                        )
                );

        System.out.println(caloricLevelsByType);

        caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                                    else return Dish.CaloricLevel.FAT;
                                },
                                toCollection(HashSet::new)
                                )
                        )
                );

        System.out.println(caloricLevelsByType.get(Type.FISH).getClass());

        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        System.out.println(vegetarianDishes);*/

        List<Dish>  vegetarianDishes =
                menu.stream().peek(e -> {System.out.println("-----------");System.out.println(e);}).filter(Dish::isVegetarian).peek(e -> {System.out.println("-----------2");System.out.println(e);}).collect(toList());
        System.out.println(vegetarianDishes);


        /*Map<Boolean, Dish> map = menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(map);

        Map<Boolean, Map<Boolean, List<Dish>>> collect3 = menu.stream().collect(partitioningBy(Dish::isVegetarian,
                partitioningBy(d -> d.getCalories() > 500)));
        System.out.println(collect3);


        Map<Boolean, Long> collect4 = menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));
        System.out.println(collect4);

        Map<Boolean, Map<Type, List<Dish>>> collect5 = menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(collect5);
        Map<Type, ArrayList<Dish>> collect6 = menu.stream().collect(groupingBy(Dish::getType, toCollection(ArrayList::new)));
        System.out.println(collect6);

        menu.stream().collect(toList());*/

    }
}
