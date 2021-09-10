package com.sc.cd.demo;

public class Singleton {

    private Singleton(){};

    private static volatile Singleton  INSTANCE=null;

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
    }
}
