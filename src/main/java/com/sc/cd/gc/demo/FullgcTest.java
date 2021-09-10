package com.sc.cd.gc.demo;


/**
 * -Xms20m -Xmx20m -XX:NewSize=10m -XX:MaxNewSize=10m
 * -XX:PretenureSizeThreshold=3m
 * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
 * -XX:+PrintGCDateStamps -XX:+PrintGCDetails
 */
public class FullgcTest {

    public static void main(String[] args) {
        // 大对象直接进入老年代
        byte[] arr1 = new byte[4 * 1024 * 1024];
        arr1 = null;

        byte[] arr2 = new byte[2 * 1024 * 1024];
        // 触发full gc
        byte[] arr3 = new byte[2 * 1024 * 1024];
        byte[] arr4 = new byte[2 * 1024 * 1024];
        byte[] arr5 = new byte[128* 1024];

        byte[] arr6 = new byte[2 * 1024 * 1024];

        while(true) {

        }
    }
}
