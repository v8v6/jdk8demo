package com.sc.cd.jdk8.stream.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 16:36
 */
public class Test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("P1");
        p1.setAge(10);

        Person p2 = new Person();
        p2.setName("pp2");
        p2.setAge(9);

        Person p3 = new Person();
        p3.setName("p3");
        p3.setAge(5);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        // 若最后不添加collect方法，则返回类型是stream
        list = list.stream().filter(person -> person.getAge()>5).collect(Collectors.toList());
        System.out.println(list);

        List<String> strs = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> collect = strs.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println(collect);

        collect = strs.stream().filter(str -> str.isEmpty()).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("=====================");
        collect = strs.stream().filter(str -> 1==1).collect(Collectors.toList());
        System.out.println(collect);
        collect = strs.stream().filter(str -> 1!=1).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("=====================");

        // optional demo
        Person person = new Person();
        person.setAge(12);
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        System.out.println(person);
        Boolean flag = optionalPerson.map(pson -> pson.getAge() > 13).orElseThrow(() -> new RuntimeException("null exection"));
        System.out.println(flag);

    }
}
