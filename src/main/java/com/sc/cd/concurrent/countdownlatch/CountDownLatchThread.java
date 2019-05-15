package com.sc.cd.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-28 11:46
 */
@Slf4j
public class CountDownLatchThread extends Thread {

    private CountDownLatch countDownLatch;

    private Integer i;

    public CountDownLatchThread(CountDownLatch countDownLatch, Integer i) {
        this.i = i;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        log.info("Thread name:{} begin,i:{}", Thread.currentThread().getName(), i);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        countDownLatch.countDown();
        log.info("Thread name:{},i:{}", Thread.currentThread().getName(), i);
    }
}
