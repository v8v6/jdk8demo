package com.sc.cd.jdk8.stream.maptoint;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 16:56
 */
public class Test {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("1", "3", "5");
        // maptoInt之后是IntStream类型，需要用boxed转换为Stream
        List<Integer> list = Stream.of("1","2").mapToInt(e ->Integer.parseInt(e)).boxed().collect(Collectors.toList());
        System.out.println(list);
        String collect = stringStream.mapToInt(Integer::parseInt).boxed().filter(x -> x >= 3).map(x -> String.valueOf(x)).collect(Collectors.joining(","));
        System.out.println(collect);


        Stream<Integer> integerStream = Stream.of(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics summaryStatistics = integerStream.mapToInt(x -> x).summaryStatistics();
        int max = summaryStatistics.getMax();
        int min = summaryStatistics.getMin();
        System.out.println(max+"_"+min);


    }
}
