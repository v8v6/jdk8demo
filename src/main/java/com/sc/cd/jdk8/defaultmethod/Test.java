package com.sc.cd.jdk8.defaultmethod;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-11-30 22:29
 */
public class Test {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.defaultMethod();
    }
}
