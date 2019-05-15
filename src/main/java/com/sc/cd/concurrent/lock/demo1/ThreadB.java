package com.sc.cd.concurrent.lock.demo1;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-04-11 09:11
 */
public class ThreadB extends Thread{

    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
