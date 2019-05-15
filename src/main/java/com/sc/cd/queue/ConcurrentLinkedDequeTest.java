package com.sc.cd.queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-29 10:16
 */
public class ConcurrentLinkedDequeTest {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(1 ^ 2 ^ 3);
        System.out.println(1 ^ 2 ^ 3 ^ 4);
        System.out.println(1 ^ 2 ^ 3 ^ 4 ^ 5);
        System.out.println(1 ^ 2 ^ 4);
        // System.out.println(1 || 2 || 4);
        System.out.println(1 ^ 2 ^ 4);
    }
}
