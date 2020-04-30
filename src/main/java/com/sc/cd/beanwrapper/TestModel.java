package com.sc.cd.beanwrapper;

import java.util.Date;

import lombok.Data;

/**
 * @author junxchen
 * @date 2020-04-27
 */

@Data
public class TestModel {

    private int age;
    private Date birth;
    private String name;
    private boolean good;
    private long times;
}
