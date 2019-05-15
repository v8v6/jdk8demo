package com.sc.cd.concurrent.semaphore;

import java.util.concurrent.Semaphore;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-28 16:22
 */

@Slf4j
@AllArgsConstructor
public class SemaphoreThread extends Thread {

    private Semaphore semaphore;

    private Integer i;


    @Override
    public void run() {

        try {
            semaphore.acquire();
            log.info("task begin:{}",i);
            Thread.sleep(5000);
            log.info("task end:{}",i);
            semaphore.release();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }
}
