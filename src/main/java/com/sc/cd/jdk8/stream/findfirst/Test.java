package com.sc.cd.jdk8.stream.findfirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 17:09
 */
public class Test {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("1", "", "2", "9", "", "3", "4", "2", "7", "", "9");
        Optional<String> optional = strs.stream().findFirst();
        // 容器若不为空则执行括号中的Lambda表达式
        optional.ifPresent(System.out::println);
        System.out.println(optional.get());

        strs = new ArrayList<>();
        optional = strs.stream().findFirst();
        // 判断容器中是否有值
        System.out.println(optional.isPresent());
        // 获取容器中的元素，若容器为空则返回括号中的默认值
        String other = optional.orElse("other");
        System.out.println(other);
        System.out.println(optional.get());

    }
}
