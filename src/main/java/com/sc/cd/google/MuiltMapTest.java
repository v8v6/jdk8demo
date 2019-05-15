package com.sc.cd.google;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-02 22:31
 */
public class MuiltMapTest {
    public static void main(String[] args) {
        Multimap<String,Integer> result = ArrayListMultimap.create();
        System.out.println(result.get("abc"));
        Collection<Integer> list = result.get("abc");
        list.add(12);
        list.add(13);
        System.out.println(result.get("abc"));

        Map<String,Object> map = Maps.newHashMap();
        Object o = map.get("123");
        System.out.println(map.containsKey("123"));
        System.out.println(o);
        Collections.EMPTY_MAP.forEach((k,v) -> {System.out.println(k);});


    }
}
