package com.sc.cd.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-09 09:29
 */
@Slf4j
public class MyTest {
    public static void main(String[] args)  {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });
        executor.shutdown();

        try {
            log.info("result:{}", result.get());
        } catch (InterruptedException e) {
            log.error(e.getMessage(),e);
        } catch (ExecutionException e) {
            log.error(e.getMessage(),e);
        }


        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });
        new Thread(task).start();
        try {
            log.info("result:{}", task.get());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }


        executor = Executors.newSingleThreadExecutor();
        task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });
        executor.submit(task);
        try {
            log.info("result:{}", task.get());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }

    }
}
