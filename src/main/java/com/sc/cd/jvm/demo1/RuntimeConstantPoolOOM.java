package com.sc.cd.jvm.demo1;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-05-15 14:30
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list  = Lists.newArrayList();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
