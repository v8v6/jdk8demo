package com.sc.cd.action.eight;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-25 16:48
 */
public interface B extends A{

    default void hello() {
        System.out.println("Hello from B");
    }
}
