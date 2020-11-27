package com.sc.cd.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * @Author junxchen
 * @Date 2020/10/12
 */
public class CollecitonUtilDemo {

    public static void main(String[] args) {
        List<Integer> temp1 = Lists.newArrayList(1, 2, 3, 4, 6);
        List<Integer> temp2 = Lists.newArrayList(2, 3, 4);

        // 并集
        Collection<Integer> union = CollectionUtils.union(temp1, temp2);
        System.out.println(union);

        // 交集
        Collection<Object> intersection = CollectionUtils.intersection(temp1, temp2);
        System.out.println(intersection);

        // 交集的补集
        Collection<Integer> disjunction = CollectionUtils.disjunction(temp1, temp2);
        System.out.println(disjunction);

        // 集合相减
        Collection<Integer> subtract = CollectionUtils.subtract(temp1, temp2);
        System.out.println(subtract);
        Collection<Integer> subtract1 = CollectionUtils.subtract(temp2, temp1);
        System.out.println(subtract1);

        Random rn = new Random(10);
        int i = rn.nextInt(100);
        System.out.println(i);
    }
}
