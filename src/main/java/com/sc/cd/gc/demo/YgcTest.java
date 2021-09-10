package com.sc.cd.gc.demo;


/**
 * -Xms10m -Xmx10m -XX:NewSize=5m -XX:MaxNewSize=5m
 * -XX:PretenureSizeThreshold=10m -XX:+UseParNewGC
 * -XX:+UseConcMarkSweepGC -XX:+PrintGCDateStamps
 * -XX:+PrintGCDetails
 *
 * 10M堆大小 5M新生代大小 默认E区 S1、S2 8:1:1
 * 最大对象10M 直接进入老年代 使用ParNew作为新生代GC收集器
 * 使用CMS作为老年代收集器
 */
public class YgcTest {

    /**
     * 初始进入就进行了一次YGC
     */
    public static void main(String[] args) {
        System.out.println(1);
        byte[] arr1 = new byte[1024 * 1024];
        arr1 = new byte[1024 * 1024];
        arr1 = new byte[1024 * 1024];
        arr1 = null;
        // 这里又进行了一次YGC
        byte[] arr2 = new byte[2 * 1024 * 1024];
    }
}
