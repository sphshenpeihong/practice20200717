package com.sph.practice.test.juc.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class LockTest {

    ReentrantLock lock = new ReentrantLock(true);

    // 公平锁

    /**
     * 深入探究公平锁的底层
     */
    @Test
    public void test1() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println("当前线程：" + Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }, String.valueOf(i)).start();
        }
        TimeUnit.SECONDS.sleep(10);

    }

}
