package com.sc.cd.jdk8.methodrenfence.demo2;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 13:56
 */

@FunctionalInterface
public interface ParseInterface {

    /**
     * 转换int
     * @param str
     * @return
     */
    int parse(String str);
}
