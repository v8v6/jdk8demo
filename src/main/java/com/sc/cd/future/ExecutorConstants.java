package com.sc.cd.future;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenjunxi1
 * @date 2023/5/19
 */
public class ExecutorConstants {

    /**
     * 线程池,当前任务超过任务队列以及最大线程数时,任务交由调用线程处理
     */
    public static final Executor EXECUTOR
            = TtlExecutors.getTtlExecutor(new ThreadPoolExecutor(5, 200, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(50),
            new ThreadFactoryBuilder().setNameFormat("biz-executor-pool-%d").setDaemon(true).build(),
            new ThreadPoolExecutor.CallerRunsPolicy()));
}
