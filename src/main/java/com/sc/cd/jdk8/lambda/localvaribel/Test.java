package com.sc.cd.jdk8.lambda.localvaribel;


/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-11-30 23:45
 */
public class Test {

    static int num = 13;

    public static void main(String[] args) {
        int age = 9;
        // lambda
        MyInterface myInterface = () -> System.out.println(age);
        myInterface.print();
        // lambda 简写
        // 编译报错
        // myInterface = () -> a++;
        myInterface = () -> num++;
        myInterface.print();
        System.out.println(num);
    }
}
