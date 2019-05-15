package com.sc.cd.lombox;

import java.util.Date;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-01 22:39
 */
public class Test {
    public static void main(String[] args) {
        User user = User.builder().id(1).name("2").createTime(new Date()).build();
        System.out.println(user);
        User build = user.toBuilder().id(3).build();
        System.out.println(build);
    }
}
