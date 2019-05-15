package com.sc.cd.jdk8.stream.foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.sc.cd.jdk8.stream.group.Student;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 17:09
 */
public class Test {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("1", "", "2", "3", "4", "", "7");
        stringStream.filter(str -> !str.isEmpty()).forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("x");
        list.add("y");
        list.add("z");

        list.parallelStream().forEach(x -> System.out.println(x));
        list.parallelStream().forEachOrdered(x -> System.out.println(x));


        //主要的区别在并行流的处理上
        //输出的顺序不一定（效率更高）
        Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Output:" + s));
        //输出的顺序与元素的顺序严格一致
        Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output:" + s));

        List<Student> list1 = Arrays.asList(
                new Student(null, "one", "zhao"), new Student(null, "one", "qian"), new Student(null, "two", "sun"));

        Student stu = list1.stream().min(Comparator.comparing(Student::getId,
                Comparator.nullsLast(Comparator.naturalOrder()))).get();
        System.out.println(stu);
        System.out.println("11111111");

        list1.stream().map(student -> {
            student.setGroupId("test");
            return student;
        });
        System.out.println(list1);

        System.out.println(null instanceof Integer);
        // System.out.println(1 == stu.getId());


        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3 | 1 << 2);

        System.out.println(1 << 4);

    }
}
