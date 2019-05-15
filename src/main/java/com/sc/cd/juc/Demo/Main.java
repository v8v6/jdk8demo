package com.sc.cd.juc.Demo;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-04-25 10:59
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    log.info("start Time : {}", System.currentTimeMillis());
                    while (true) {

                    }
                } catch (Exception ex) {
                    log.error(ex.getMessage(), ex);
                    log.info("error Time : {}", System.currentTimeMillis());
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();
            Thread.sleep(2000);
            log.info("state: {}", Thread.interrupted());
            log.info("state: {}", thread.isInterrupted());
        } catch (Exception ex) {

        }
    }
}
