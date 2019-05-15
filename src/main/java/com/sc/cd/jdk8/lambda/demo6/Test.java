package com.sc.cd.jdk8.lambda.demo6;


/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-11-30 23:45
 */
public class Test {
    public static void main(String[] args) {
        // lambda
        MyInterface myInterface = () -> System.out.println("111111");
        myInterface.print();
        // lambda 简写
        myInterface = () -> {};
        myInterface.print();
    }
}
