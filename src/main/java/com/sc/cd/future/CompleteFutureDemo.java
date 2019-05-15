package com.sc.cd.future;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-09 09:51
 */
@Slf4j
public class CompleteFutureDemo {

    @Test
    public void testCompletableFuture() {
        String result = CompletableFuture.supplyAsync(() -> {
            log.info("1 start :{}",System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = 1/0;
            log.info("1 end :{}",System.currentTimeMillis());
            return "Hello ";
        }).thenApplyAsync(v -> v + "world").exceptionally(e -> {
            log.error(e.getMessage(),e);
            return "111";
        }).join();
        log.info("2 start :{}",System.currentTimeMillis());
        log.info(result);

        CompletableFuture.supplyAsync(() -> {
            return "Hello ";
        }).thenAccept(v -> {
            log.info("consumer: {}", v);
        });

        result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            return "Hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            return 1111;
        }), (s1, s2) -> s1 + " " + s2).join();
        log.info(result);

        result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            return "Hi Boy";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            return "Hi Girl";
        }), s -> s).join();
        log.info(result);

        result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            if (true) {
                throw new RuntimeException("exception test!");
            }
            return "Hi Boy";
        }).exceptionally(e -> {
            log.error(e.getMessage(), e);
            return "Hello world!";
        }).join();
        log.info(result);
    }
}
