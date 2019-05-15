package com.sc.cd.jdk8.stream.sort;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-20 14:22
 */
public   class User {

    public User(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return code + "---" + name;
    }
}
