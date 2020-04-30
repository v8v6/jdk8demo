package com.sc.cd.recursion;

import java.util.Random;

public class RecursionDemo {

    public static void main(String[] args) {
        //Object o = retryDelete(new Object(), 2);
        Random r = new Random();
        for (int i = 3000; i> 0;i--) {
            System.out.println(r.nextInt(127) + 1);
        }
    }

    private static Object retryDelete(Object o, Integer count) {
        for (int i = count; i > 0; i--) {
            try {
                System.out.println("删除");
                if (i!=2) {
                    int j = 1/0;
                }
                return o;
            } catch (Exception ex) {
                if (i - 1 <= 0) {
                    throw new RuntimeException("次数用尽。。。");
                }
                System.out.println("删除异常");
                return retryDelete(o, i - 1);
            }
        }
        return null;
    }
}
