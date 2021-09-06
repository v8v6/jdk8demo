package com.sc.cd.random;

import com.alibaba.fastjson.JSONObject;

import java.security.SecureRandom;
import java.util.List;

public class Demo {

    private static SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) throws InterruptedException {
        List<Object> objects = JSONObject.parseArray("", Object.class);
        System.out.println(objects);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    int j = secureRandom.nextInt(100);
                    System.out.println("th"+j);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    int j = secureRandom.nextInt(10);
                    System.out.println("t2222h"+j);
                }

            }
        }).start();


        Thread.sleep(200000L);


    }
}

