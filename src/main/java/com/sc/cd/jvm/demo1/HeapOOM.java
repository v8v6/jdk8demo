package com.sc.cd.jvm.demo1;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 描述:
 *   -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author junxi.chen
 * @create 2019-05-15 14:10
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = Lists.newArrayList();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
