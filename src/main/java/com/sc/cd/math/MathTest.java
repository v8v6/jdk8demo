package com.sc.cd.math;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-31 10:30
 */
public class MathTest {
    public static void main(String[] args) {
        double ceil = Math.ceil(199d / 5);
        for (int i = 1; i <= ceil; i++) {
            System.out.println(i);
        }
    }
}
