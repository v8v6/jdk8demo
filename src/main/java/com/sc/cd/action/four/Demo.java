package com.sc.cd.action.four;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-23 21:00
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
                new Dish("salmon", false, 450, Dish.Type.FISH) );


        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(collect);

        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNames);

        List<String> names =
                menu.stream()
                        .filter(d -> {
                            System.out.println("filtering" + d.getName());
                            return d.getCalories() > 300;
                        })
                        .map(d -> {
                            System.out.println("mapping" + d.getName());
                            return d.getName();
                        })
                        .limit(3)
                        .collect(toList());
        System.out.println(names);




        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        /*List<Stream<String>> list = streamOfwords
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println(list);*/

        List<String> uniqueCharacters =
                streamOfwords
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(uniqueCharacters);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares =
                numbers.stream()
                        .map(n -> n * n)
                        .collect(toList());

        System.out.println(squares);



        int count = menu.stream()
                .map(d -> {
                    System.out.println(d);
                    return  1;
                })
                .reduce(0, (a, b) ->{
                    System.out.println(a+"_"+b);
                    return a+b;
                });

        System.out.println(count);


        Optional<Integer> optional = numbers.stream().reduce(Integer::max);
        optional.ifPresent(System.out::println);

        optional = numbers.stream().reduce(Integer::sum);
        optional.ifPresent(System.out::println);

        long c = numbers.stream().count();
        System.out.println(c);

        Integer cc = numbers.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
        System.out.println(cc);

        int sum = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println(sum);

        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories);


        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
        stream.forEach(System.out::println);


        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int i = maxCalories.orElse(1);
        System.out.println(i);

    }
}
