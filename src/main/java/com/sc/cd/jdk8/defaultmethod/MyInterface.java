package com.sc.cd.jdk8.defaultmethod;

/**
 * 描述:
 * MyInterface
 *
 * @author junxi.chen
 * @create 2018-11-30 22:27
 */
public interface MyInterface {

    default void defaultMethod(){
        System.out.println("....defaultMethod");
    }
}
