package com.sc.cd.poi;

import java.util.HashMap;

import com.google.common.collect.Maps;

public class POITest {

    private static final ThreadLocal<Object> tl = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put("1", new Object());
        Object o = hashMap.get("1");
        hashMap.remove("1");
        System.out.println(o);
        tl.set(new Object());

        Object o1 = tl.get();
        tl.remove();
        System.out.println(o1);


        String s = String.format("{\"first\":{\"value\":\"%s\"},\"keyword1\":{\"value\":\"%s\"},\"keyword2\":{\"value\":\"%s\"},\"keyword3\":{\"value\":\"%s\"},\"remark\":{\"value\":\"remark\"},\"url\":\"%s\"}", "王力", "王力", "王力", "王力", "王力");
        System.out.println(s);

    }

    private void get() {
        if (1==1) {
            throw new RuntimeException();
        }
    }
}
