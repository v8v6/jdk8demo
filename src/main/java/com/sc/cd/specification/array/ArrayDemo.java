package com.sc.cd.specification.array;

/**
 * 描述:
 * 测试array split
 *
 * @author junxi.chen
 * @create 2018-11-30 16:51
 */
public class ArrayDemo {
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        // 预期大于3，结果是3
        System.out.println(ary.length);
    }
}
