package com.sc.cd.concurrent.lock.demo;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-04-11 09:11
 */
public class ThreadA extends Thread{

    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}
