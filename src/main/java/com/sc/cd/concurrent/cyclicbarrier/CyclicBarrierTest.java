package com.sc.cd.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-28 11:35
 */
@Slf4j
public class CyclicBarrierTest {

    public static void main(String[] args) {
        int count = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count,
                () -> log.info("执行barrierAction操作!"));
        //开启10个子线程执行子任务
        for (int i = 0; i < count; i++) {
            Thread thread = new CyclicBarrierThread(cyclicBarrier, i);
            thread.start();
        }
        try {
            log.info("task end...");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
