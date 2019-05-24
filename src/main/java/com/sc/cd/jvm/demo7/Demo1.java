package com.sc.cd.jvm.demo7;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-05-22 14:39
 */
public  class Demo1 {

    static class DeadLoopClass {
        // 有静态代码块，才会执行 clinit方法
        static {
            // 如果不加上这个if语句，编译器将提示“Initializer does not complete normally”并拒绝编译
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                }

            }
        }
    }

    public static void main(String[] args) {

        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
