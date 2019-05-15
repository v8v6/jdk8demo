package com.sc.cd.jdk8.staticmethod;

public interface MyInterface {

    void test();

    static void staticMethod(){
        System.out.println("staticMethod..........");
    }
}
