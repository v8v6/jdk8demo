package com.sc.cd.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {

    Object data;
    volatile boolean cacheValid;
    static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        processCachedData();
    }

    static void processCachedData() {
        rwl.readLock().lock();
            //如果缓存过期，释放读锁，并获取写锁
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                //重新检查缓存是否过期，因为有可能在当前线程操作之前，其他写线程有可能改变缓存状态
                // 获取读锁
                rwl.readLock().lock();
            } finally {
                //释放写锁
                rwl.writeLock().unlock();
            }


        try {

        } finally {
            rwl.readLock().unlock();//最后释放读锁
        }
    }

}
