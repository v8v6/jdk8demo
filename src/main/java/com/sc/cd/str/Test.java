package com.sc.cd.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Strings;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-05 14:03
 */
public class Test {


    public static void main(String[] args) {
        System.out.println("Text to analyze".length());

        // create an array of string objs
        String init[] = { "One", "Two", "Three", "One", "Two", "Three" };

        // create one list
        List list = new ArrayList(Arrays.asList(init));

        System.out.println("List value before: "+list);


        // create singleton list
        /*list = Collections.singletonList("TP");
        System.out.println("List value after: "+list);
        list.add("rrr");
        System.out.println("List value after: "+list);
*/
        System.out.println("===================");

        String str ="";
       // System.out.println(o);
    }
}
