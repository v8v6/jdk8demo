package com.sc.cd.jdk8.lambda.demo2;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-11-30 23:22
 */
public class Test {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        System.out.println(myInterface.sum(1,4));
    }
}
