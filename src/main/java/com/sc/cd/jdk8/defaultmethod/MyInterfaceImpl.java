package com.sc.cd.jdk8.defaultmethod;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-11-30 22:28
 */
public class MyInterfaceImpl implements MyInterface {

    @Override
    public void defaultMethod() {
        MyInterface.super.defaultMethod();
        System.out.println("..impl defaultMethod");
    }
}
