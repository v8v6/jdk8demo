package com.sc.cd.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-28 15:23
 */
@Slf4j
public class Demo {

    private static ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 30, 1,
            TimeUnit.MINUTES, new LinkedBlockingDeque<>(1024), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).parallel().mapToObj(taskNo -> {
            log.info("批次任务开始执行，taskNo：{}", taskNo);
            return CompletableFuture.completedFuture(CompletableFuture.supplyAsync(() -> listGsInfo(taskNo), executor).join())
                    .thenApplyAsync(str -> syncGsInfoToEs(str), executor);
        }).collect(Collectors.toList());
    }

    private static String listGsInfo(Integer taskNo) {
        log.error("taskNo:{}", taskNo);
        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task :{} end",taskNo);
        return "OK";
    }


    private static String syncGsInfoToEs(String str) {
        return "END";
    }

}
