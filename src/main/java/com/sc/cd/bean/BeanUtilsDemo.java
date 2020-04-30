package com.sc.cd.bean;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.BeanUtils;

/**
 * @author junxchen
 * @date 2020-04-28
 */
public class BeanUtilsDemo {
    public static void main(String[] args) {
        System.out.println(BeanUtils.isSimpleProperty(Timestamp.class));
        System.out.println(BeanUtils.isSimpleProperty(Date.class));
        System.out.println(BeanUtils.isSimpleProperty(java.sql.Date.class));
        System.out.println(BeanUtils.isSimpleProperty(FlMemberUser.class));
    }
}
