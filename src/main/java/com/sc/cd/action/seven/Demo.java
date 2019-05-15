package com.sc.cd.action.seven;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;


/**
 * @author junxi.chen
 * @create 2018-12-24 10:53
 */
public class Demo {

    public static void main(String[] args) {

        long l = forkJoinSum(10);
        System.out.println(l);
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
