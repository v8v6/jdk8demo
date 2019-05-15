package com.sc.cd.jdk8.methodrenfence.demo2;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 13:41
 */
public class Test {

    public static void main(String[] args) {

        // 匿名内部类方式
        ParseInterface parseInterface = new ParseInterface() {
            @Override
            public int parse(String str) {
                return Integer.parseInt(str);
            }
        };

        int i = parseInterface.parse("111");
        System.out.println(i);

        // lambda方式
        parseInterface = str -> Integer.parseInt(str);
        i = parseInterface.parse("123");
        System.out.println(i);

        // 静态方法引用
        parseInterface = Integer::parseInt;
        i = parseInterface.parse("1234");
        System.out.println(i);

    }
}
