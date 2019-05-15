package com.sc.cd.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.Lists;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-02 10:22
 */
public class Demo {

    public static void main(String[] args) {
        List<String> ids1 = Arrays.asList("111","222","244","555");
        List<String> ids2 = Arrays.asList("111","222","24444","11555");
        Collection<String> intersection = CollectionUtils.intersection(ids1, ids2);
        if(CollectionUtils.isNotEmpty(intersection)){
            intersection.stream().forEach(System.out::println);
        }
        Map<String,Map<String,String>> map = null;
        Map<String,Map<String,String>> optionMap = Optional.ofNullable(map).orElse(Collections.EMPTY_MAP);
        System.out.println(optionMap);
        System.out.println(optionMap.containsKey("demo"));
    }
}
