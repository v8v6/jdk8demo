package com.sc.cd.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-28 11:46
 */
@Slf4j
public class CyclicBarrierThread extends Thread {

    private CyclicBarrier cyclicBarrier;

    private Integer i;

    public CyclicBarrierThread(CyclicBarrier cyclicBarrier, Integer i) {
        this.i = i;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        log.info("Thread name:{} begin,i:{}", Thread.currentThread().getName(), i);
        try {
            Thread.sleep(5000);
            log.info("Thread name:{},i:{}", Thread.currentThread().getName(), i);
            cyclicBarrier.await();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        //释放资源
        log.info("线程：{} 释放资源!",i);
    }
}
