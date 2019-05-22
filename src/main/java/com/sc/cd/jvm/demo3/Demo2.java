package com.sc.cd.jvm.demo3;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-05-16 18:24
 */
public class Demo2 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation = new byte[3 * _1MB];  //直接分配在老年代中
    }
}
