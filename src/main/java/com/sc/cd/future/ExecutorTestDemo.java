package com.sc.cd.future;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class ExecutorTestDemo {

    public static void main(String[] args) {
        testMultiThreadExec();

        log.info("第二轮多线程执行");
        testMultiThreadExec();
    }

    private static void testMultiThreadExec() {
        List<CompletableFuture<Void>> combinedFutureList = Lists.newArrayList();

        for (int i = 0; i < 500; i++) {
            // 按照每个料塔进行查询实时值
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                try {
                    log.info("start........,{}", Thread.currentThread().getName());
                    Thread.sleep(10000L);
                    log.info("end........,{}", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, ExecutorConstants.EXECUTOR);
            combinedFutureList.add(completableFuture);
        }
        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(combinedFutureList.toArray(new CompletableFuture[0]));
        // 等待所有的future执行完毕
        combinedFuture.join();
    }

}
