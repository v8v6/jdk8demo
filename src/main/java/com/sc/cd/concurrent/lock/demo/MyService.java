package com.sc.cd.concurrent.lock.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-04-11 09:09
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    //获取两个Condition
    private Condition condition = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA时间：" + System.currentTimeMillis() + "="+ System.nanoTime()+ "----" + Thread.currentThread().getName());
            condition.await();
            System.out.println("end awaitA时间：" + System.currentTimeMillis() + "="+ System.nanoTime()+ "----" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB时间：" + System.currentTimeMillis() + "="+ System.nanoTime()+ "----" + Thread.currentThread().getName());
            condition.await();
            System.out.println("end awaitB时间：" + System.currentTimeMillis() + "="+ System.nanoTime()+ "----" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll() {
        try {
            lock.lock();
            System.out.println("signalAll时间为：" + System.currentTimeMillis() + "----" + Thread.currentThread().getName());
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
