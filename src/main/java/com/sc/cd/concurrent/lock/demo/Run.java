package com.sc.cd.concurrent.lock.demo;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-04-11 09:11
 */
/**
 *    测试类
 */
public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.signalAll();
    }
}
