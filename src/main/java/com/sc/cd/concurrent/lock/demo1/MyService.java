package com.sc.cd.concurrent.lock.demo1;

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
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA时间：" + System.currentTimeMillis() + "="+ System.nanoTime()+ "----" + Thread.currentThread().getName());
            conditionA.await();
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
            conditionB.await();
            System.out.println("end awaitB时间：" + System.currentTimeMillis() + "="+ System.nanoTime()+ "----" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll时间为：" + System.currentTimeMillis() + "----" + Thread.currentThread().getName());
            // conditionA.signalAll();
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll时间为：" + System.currentTimeMillis() + "----" + Thread.currentThread().getName());
            conditionB.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
