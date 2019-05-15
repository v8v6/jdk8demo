package com.sc.cd.juc.Demo;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-04-25 11:45
 */
@Slf4j
public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.interrupted();
                while (!Thread.currentThread().isInterrupted()){
                    try {
                        Thread.sleep(604800000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("sleep end execute task ....");
                }

            }
        });
        thread.start();


        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                thread.interrupt();
            }
        });
        threadA.start();
    }
}
