package com.sc.cd.mockito;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-09 17:52
 */
public class Foo {

    private String test(){
        System.out.println(11);
        return null;

    }


    public static void main(String[] args) {
        List<Field> fields = Lists.newArrayList();
        Class clazz = Foo.class;
        int i =0;
        while (clazz != null && !(clazz instanceof Object)) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
            System.out.println(i++);
        }
    }
}
