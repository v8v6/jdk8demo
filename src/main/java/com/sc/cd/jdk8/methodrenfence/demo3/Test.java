package com.sc.cd.jdk8.methodrenfence.demo3;

import java.util.function.Function;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 13:41
 */
public class Test {

    public static void main(String[] args) {


        // 匿名内部类方式
        String str = "qwerty";
        Function<String, Boolean> function = new Function<String, Boolean>() {
            @Override
            public Boolean apply(String suffix) {
                return  str.endsWith(suffix);
            }
        };

        Boolean flag = function.apply("q");
        System.out.println(flag);

        // lambda简写
        function = suffix -> str.endsWith(suffix);
        flag = function.apply("y");
        System.out.println(flag);

        // 实例方法引用

        function = str::endsWith;
        flag = function.apply("y");
        System.out.println(flag);
    }
}
