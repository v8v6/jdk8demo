package com.sc.cd.jdk8.lambda.demo5;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-11-30 23:45
 */
public class Test {
    public static void main(String[] args) {
        // lambda
        MyInterface myInterface = (String a) -> {
            System.out.println(a);
        };
        myInterface.print("aaa");
        // lambda 简写
        myInterface = a -> System.out.println(a);
        myInterface.print("bbbbbbbbbbb");
    }
}
