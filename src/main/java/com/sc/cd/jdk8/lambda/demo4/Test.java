package com.sc.cd.jdk8.lambda.demo4;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-11-30 23:45
 */
public class Test {
    public static void main(String[] args) {
        // lambda
        MyInterface myInterface = (int a, int b) -> {return a + b; };
        System.out.println(myInterface.sum(1,2));
        // lambda 简写
        myInterface = (a, b) -> {return a + b; };
        System.out.println(myInterface.sum(1,2));

        myInterface = (a, b) ->  a + b;
        System.out.println(myInterface.sum(1,22));
    }
}
