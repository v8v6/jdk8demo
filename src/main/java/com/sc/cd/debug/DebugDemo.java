package com.sc.cd.debug;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-08 09:54
 */
public class DebugDemo {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        String a = "str";
        list.add(a);

        list.add(a);
        System.out.println(list);

        list.add(a);


    }
}
