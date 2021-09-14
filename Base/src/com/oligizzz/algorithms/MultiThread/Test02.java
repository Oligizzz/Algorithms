package com.oligizzz.algorithms.MultiThread;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/31
 * @Modify By:
 */
public class Test02 {
    public static void main(String[] args) {
        doABCPrint test = new doABCPrint();
        new Thread(() -> {
            test.doA( 1);
        }, "线程A").start();
        new Thread(() -> {
            test.doB( 2);
        }, "线程B").start();
        new Thread(() -> {
            test.doC( 3);
        }, "线程C").start();
    }

}

class doABCPrint {
    private Lock lock = new ReentrantLock();
    private int num = 1;
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void doA(int target) {
        lock.lock();
        try {
            while (num % target != 0) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + ":A");
            num++;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void doB(int target) {
        lock.lock();
        try {
            while (num % target != 0) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + ":B");
            num++;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void doC(int target) {
        lock.lock();
        try {
            while (num % target != 0) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + ":C");
            num++;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

