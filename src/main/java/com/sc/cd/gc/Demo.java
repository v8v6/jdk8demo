package com.sc.cd.gc;

import com.google.common.collect.Maps;

import java.util.HashMap;

public class Demo {

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put(null, null);
        System.out.println(hashMap);
    }
}
