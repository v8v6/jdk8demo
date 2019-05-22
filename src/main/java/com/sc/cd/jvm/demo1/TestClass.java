package com.sc.cd.jvm.demo1;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-05-21 09:28
 */
public class TestClass implements Serializable,Cloneable {
    private int m;

    public int inc() {
        return m + 1;
    }
}
