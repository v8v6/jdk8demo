package com.sc.cd.proxy.dynamic;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

public class Demo1 {
    public static void main(String[] args) throws Exception {

        System.out.println(5 / 10);
        Member member = new Member();

        Dog d = new Dog();
        d.setName("dog");
        Buy buy = new Buy();
        buy.setName("buy");
        buy.setDog(d);
        member.setBuy(buy);
        member.setName("member");
        String elParam = "member.buy.name";
        elParam = "buy.dog.name";

        Object value = getValue(elParam, member);
        System.out.println(value);
    }


    public static Object getValue(String elParam, Object obj)
            throws Exception {
        if (Objects.isNull(obj)) {
            return null;
        }
        Class clz = obj.getClass();
        String[] paramArr = elParam.split("\\.");
        if (paramArr.length == 1) {
            Method method = clz.getMethod(generateMethodName("get", paramArr[0]));
            if (Objects.nonNull(method)) {
                return method.invoke(obj);
            }
        } else {
            Method method = clz.getMethod(generateMethodName("get", paramArr[0]));
            if (Objects.nonNull(method)) {
                Object o = method.invoke(obj);
                paramArr[0] = null;
                String temp = Arrays.stream(paramArr)
                        .filter(StringUtils::isNotBlank)
                        .collect(Collectors.joining("."));
                return getValue(temp, o);
            }
        }
        return null;
    }

    private static String generateMethodName(String prefix, String field) {
        String prop = Character.toUpperCase(field.charAt(0)) + field.substring(1);
        String methodName = prefix + prop;
        return methodName;
    }

    @Data
    static class Member {

        private String name;

        private String age;

        private Buy buy;


    }

    @Data
    static class Buy {
        private String name;

        private String age;

        private Dog dog;
    }

    @Data
    static class Dog {
        private String name;

        private String age;
    }

}
