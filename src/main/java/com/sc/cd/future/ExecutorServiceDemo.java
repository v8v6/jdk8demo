package com.sc.cd.future;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-15 13:59
 */
@Slf4j
public class ExecutorServiceDemo {

    private static  ExecutorService executorService =
            new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());


    public static void main(String[] args) {
        testExecutorCompletionService();
    }


    public static void testExecutorService() {
        ImmutableList<Callable<Map<String, Object>>> callables = ImmutableList.of(createCallable(), createCallable(), createCallable(), createCallable(), createCallable(), createCallable(), createCallable());
        try {
            List<Future<Map<String, Object>>> futureList = executorService.invokeAll(callables);
            futureList.stream().forEach(f -> {
                try{
                    log.info("future:{}",f.get());
                }catch (Exception ex){
                    log.error(ex.getMessage(),ex);
                }
            });
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    public static void testExecutorCompletionService() {
        CompletionService<Map<String,Object>> service = new ExecutorCompletionService<Map<String,Object>>(executorService);

        // 生产者
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    int index = i;
                    service.submit(createCallable());
                }
            }
        }.start();


        // 消费者
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Future<Map<String,Object>> future = service.take();
                        // do some thing........
                        log.info("future:{}",future.get());
                    } catch (Exception e) {
                        log.error(e.getMessage(),e);
                    }
                }
            }
        }.start();

    }

    public static Callable<Map<String, Object>> createCallable() {
        Callable<Map<String, Object>> callable = new Callable<Map<String, Object>>() {
            @Override
            public Map<String, Object> call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
                log.info("Callable 任务【 {} 】运行", Thread.currentThread().getName());
                Map<String, Object> map = Maps.newHashMap();
                map.put("successCount", Thread.currentThread().getId());
                map.put("failCount", 1);
                map.put("failCodes", Arrays.asList("1", "2"));
                return map;
            }
        };
        return callable;
    }
}
