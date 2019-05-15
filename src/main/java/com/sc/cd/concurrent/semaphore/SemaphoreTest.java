package com.sc.cd.concurrent.semaphore;

import java.util.concurrent.Semaphore;

import com.sc.cd.concurrent.cyclicbarrier.CyclicBarrierThread;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-28 16:23
 */

@Slf4j
public class SemaphoreTest {
    public static void main(String[] args) {
        Integer count = 50;
        Semaphore semaphore = new Semaphore(3);
        //开启10个子线程执行子任务
        for (int i = 0; i < count; i++) {
            Thread thread = new SemaphoreThread(semaphore, i);
            thread.start();
        }
        try {
            log.info("task end...");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
