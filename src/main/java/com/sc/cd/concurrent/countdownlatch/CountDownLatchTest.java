package com.sc.cd.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-28 11:35
 */
@Slf4j
public class CountDownLatchTest {

    public static void main(String[] args) {
        int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        //开启10个子线程执行子任务
        for (int i = 0; i < count; i++) {
            Thread thread = new CountDownLatchThread(countDownLatch, i);
            thread.start();
        }
        try {
            countDownLatch.await();
            log.info("task end...");
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }
}
