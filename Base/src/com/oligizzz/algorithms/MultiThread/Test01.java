package com.oligizzz.algorithms.MultiThread;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/31
 * @Modify By:
 */
public class Test01 {

    public static void main(String[] args){
        Print test = new Print();
        new Thread(()->{
            try {
                test.doABC("A",1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程A").start();
        new Thread(()->{
            try {
                test.doABC("B",2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程B").start();
        new Thread(()->{
            try {
                test.doABC("C",3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程C").start();
    }

}

class Print{
    private static final Object lock = new Object();
    private volatile int num = 1;

    public void doABC(String s,int target) throws InterruptedException {
        synchronized (lock){
            if(num%target != 0){
                lock.wait();
            }
            System.out.print(Thread.currentThread().getName()+":");
            System.out.println(s);
            num++;
            lock.notifyAll();
        }
    }
}
