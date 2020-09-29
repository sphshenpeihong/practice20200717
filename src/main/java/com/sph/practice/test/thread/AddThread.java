package com.sph.practice.test.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Shen Peihong on 2020/9/29 17:06
 * Description: 累加num值，当num等于5时，则唤醒其它线程，使得其它线程成为运行状态，当前线程处于就绪状态
 * 释放锁的时机：1、加锁的代码都执行完毕，方可会释放锁(必要时可在finnaly释放锁，防止代码异常，一直锁住)  2、使用lock.notify()唤起其它等待这把锁的线程，然后lock.wait()继续等待被唤醒
 *  若某块代码加了锁，那么当执行到共用同一把锁的程序时，如果锁未释放，那么将会进入等待，等待锁的释放，才可以解锁
 *
 * @since 1.0.0
 */
public class AddThread implements Runnable{
    //定义静态变量
    public static List<Integer> list = Lists.newArrayList();
    //定义同步锁
    public static Lock lock = new ReentrantLock();


    @Override
    public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.println("AddThread线程打印list:" + i);
                    list.add(i);
                    //当累加到5时，唤醒其它线程，当前线程进入就绪状态
                    if (list.size() == 5) {
                        Thread.sleep(1000);
                        lock.notify();
                        lock.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (!lock.equals(null)) {
                    lock.unlock();
                }
            }

    }
}
