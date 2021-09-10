package com.sc.cd.hutool;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * @author junxchen
 * @date 2020-05-18
 */
public class Demo {

    public static void main(String[] args) {
        Map<String, Object> tempMap = Maps.newHashMap();
        tempMap.put("name", "1");
        tempMap.put("age", 222);
        tempMap.put("time", "2010-10");

        Student student = BeanUtil.mapToBean(tempMap, Student.class, true);
        System.out.println(student);


    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Student {
        private String name;

        private Integer age;

        private Date time;
    }
}
