package com.sc.cd.jvm.demo1;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-05-15 14:30
 */
public class RuntimeConstantPoolCompare {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
