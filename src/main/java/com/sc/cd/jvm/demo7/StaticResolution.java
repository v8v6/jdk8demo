package com.sc.cd.jvm.demo7;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-05-23 09:59
 */
public class StaticResolution {
    public static void sayHello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
