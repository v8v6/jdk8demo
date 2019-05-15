package com.sc.cd.jdk8.stream.group;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-20 11:36
 */
public class FunctionX {

    public static void main(String[] args) {
        //1.分组计数
        List<Student> list1= Arrays.asList(
                new Student(1,"one","zhao"),new Student(2,"one","qian"),new Student(3,"two","sun"));

        //1.1根据某个属性分组计数
        Map<String, Long> result1=list1.stream().collect(Collectors.groupingBy(Student::getGroupId,Collectors.counting()));
        System.out.println(result1);

        Map<String, List<Student>> collect = list1.stream().collect(Collectors.groupingBy(Student::getGroupId));
        System.out.println(collect);
        System.out.println("---------------------------");
        collect.entrySet().stream().forEach(System.out::println);
        System.out.println("---------------------------");

        //1.2根据整个实体对象分组计数,当其为String时常使用
        Map<Student,Long> result2=list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(result2);

        //1.3根据分组的key值对结果进行排序、放进另一个map中并输出
        Map<String,Long> xMap=new HashMap<>();
        result1.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByKey().reversed()) //reversed不生效
                .forEachOrdered(x->xMap.put(x.getKey(),x.getValue()));
        System.out.println(xMap);

        //2.分组，并统计其中一个属性值得sum或者avg:id总和
        Map<String,Integer> result3=list1.stream().collect(
                Collectors.groupingBy(Student::getGroupId,Collectors.summingInt(Student::getId))
        );
        System.out.println(result3);

        Map<String, Double> doubleMap = list1.stream().collect(
                Collectors.groupingBy(Student::getGroupId, Collectors.averagingInt(Student::getId))
        );
        System.out.println(doubleMap);
    }
}
