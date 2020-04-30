package com.sc.cd.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        Field[] fields = Student.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                Class<?> clz = Class.forName(field.getGenericType().getTypeName());
                Method method = clz.getMethod("valueOf", String.class);
                if (Objects.nonNull(method)) {
                }
            } catch (Exception ex) {

            }

        }
    }
}
