package com.sph.practice.test.juc.atomic;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Shen Peihong on 2021/2/9
 * Description: 自定义自旋锁（提供加锁方法和解锁方法）
 *
 * @since 1.0.0
 */
public class SpinLock {

    // 定义一个原子引用对象
    static AtomicReference<Thread> reference = new AtomicReference<>(null);

    // 加锁
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "=> lock");

        while (!reference.compareAndSet(null, thread)) {

        }
    }

    // 解锁
    public void myUnlock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "=> lock");

        reference.compareAndSet(thread, null);
    }

    static class SpinLockTest {

        static SpinLock spinLock = new SpinLock();

        public static void main(String[] args) {
            // 开启两个线程，两个都是去加锁和解锁，线程1代码延时久一点，线程2需要等待线程1解锁
            new Thread(() -> {
                spinLock.myLock();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    spinLock.myUnlock();
                }
            }, "A").start();

            new Thread(() -> {
                // 线程2排在线程1后面，一直在自旋锁里面自旋，直到线程1解锁
                spinLock.myLock();
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("嘿嘿");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    spinLock.myUnlock();
                }
            }, "B").start();
        }

    }
}


