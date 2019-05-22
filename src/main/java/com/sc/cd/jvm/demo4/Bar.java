package com.sc.cd.jvm.demo4;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-05-17 11:36
 */
public class Bar {

    int a = 1;
    static int b = 2;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }
}
