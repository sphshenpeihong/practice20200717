package com.sph.practice.test.thread.thread2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程之间的通信（线程等待、通知等）
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Slf4j
public class ThreadWNTest {

    // demo1：两个线程，线程A执行的时候，如果判断原子Integer的值==0时，则等待，不等于0时，打印语句并通知
    // 线程B反过来
    // 两个线程都死循环，

    private AtomicInteger integer = new AtomicInteger(0);
    private AtomicBoolean aBoolean = new AtomicBoolean(false);

    private ReentrantLock lock = new ReentrantLock();

    /**
     *
     */
    @Test
    public void test1() throws InterruptedException {
        new Thread(() -> {
            while (true) {
                try {
                    synchronized (this) {
                        // 如果共享变量的值 == 0时，当前线程进行等待(等待通知)
                        if (!aBoolean.get()) {
                            this.wait();
                        }
                        log.info("打印当前线程名称，name = {}", Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(1);
                        aBoolean.set(true);
                        // 通知其它线程
                        Thread.currentThread().notifyAll();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "线程A").start();
        new Thread(() -> {
            while (true) {
                try {
                    // 如果共享变量的值 != 0时，当前线程进行等待(等待通知)
                    if (aBoolean.get()) {
                        this.wait();
                    }
                    log.info("打印当前线程名称，name = {}", Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                    aBoolean.set(false);
                    // 通知其它线程
                    Thread.currentThread().notifyAll();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "线程B").start();
        TimeUnit.SECONDS.sleep(30);
    }

    /**
     *
     */
    @Test
    public void test2() throws InterruptedException {
        //Thread.currentThread().wait();
        synchronized (this) {
            this.wait();
        }
    }


}
