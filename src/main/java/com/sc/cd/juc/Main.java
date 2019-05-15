package com.sc.cd.juc;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-04-25 10:58
 */
public class Main {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(i != (i =5));

        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());

        System.out.println(new AtomicInteger((-1 << 29) | 0).get());
    }
}
