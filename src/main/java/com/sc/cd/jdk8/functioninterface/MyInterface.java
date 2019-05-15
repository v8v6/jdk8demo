package com.sc.cd.jdk8.functioninterface;

/**
 * 描述:
 * MyInterface
 *
 * @author junxi.chen
 * @create 2018-11-30 22:27
 */

@FunctionalInterface
public interface MyInterface {

    void test();

    // void testMethod();

    static void staticMethod(){
        System.out.println("......staticMethod");
    }

    default void defaultMethod(){
        System.out.println("....defaultMethod");
    }
}
