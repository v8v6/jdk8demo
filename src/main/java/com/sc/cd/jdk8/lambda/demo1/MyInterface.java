package com.sc.cd.jdk8.lambda.demo1;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-11-30 23:16
 */
@FunctionalInterface
public interface MyInterface {

    /**
     * 计算和
     * @param a
     * @param b
     * @return
     */
    int sum(int a, int b);

}
