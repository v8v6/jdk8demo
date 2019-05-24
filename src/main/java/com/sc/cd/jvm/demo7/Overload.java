package com.sc.cd.jvm.demo7;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-05-23 10:15
 */
public class Overload {
    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    /*public static void sayHello(int arg) {
        System.out.println("hello int");
    }*/

    /*public static void sayHello(long arg) {
        System.out.println("hello long");
    }*/

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    /*public static void sayHello(char arg) {
        System.out.println("hello char");
    }*/

    public static void sayHello(char... arg) {
        System.out.println("hello char ...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
