package com.sc.cd.jdk8.methodrenfence.demo1;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 13:43
 */

@FunctionalInterface
public interface PersonFactory {

    /**
     * 创建Person对象
     * @param firstName
     * @param lastName
     * @return
     */
    Person createPerson(String firstName, String lastName);
}
