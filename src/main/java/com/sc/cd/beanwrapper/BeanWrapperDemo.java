package com.sc.cd.beanwrapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;

/**
 * @author junxchen
 * @date 2020-04-27
 */
public class BeanWrapperDemo {

    public static void main(String[] args) {
        TestModel tm = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(tm);
        bw.setPropertyValue("good", "on");
        //bw.setPropertyValue("good", "1");
        //bw.setPropertyValue("good", "true");
        //bw.setPropertyValue("good", "yes");
        System.out.println(tm);

        test();


    }

    private static void test() {
        TestModel tm = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(tm);
        bw.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        bw.setPropertyValue("birth", "1990-01-01");
        System.out.println(tm);
    }
}
