package com.sph.practice.test.juc.reentrantlock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单测试一下ReenTrantLock底层锁原理
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Slf4j
public class ReenTrantLockTest {

    // 两个线程，主线程和子线程，主线程先使用对象同步锁，然后在里边调用wait()方法去释放锁
    // 子线程获取到锁后，执行完代码后，去通知指定等待对象
    // 最后按照既定的执行顺序执行完业务代码

    private static final Object o = new Object();

    private static final Lock lock = new ReentrantLock();

    /**
     * 开启两个子线程A、B，然后子线程A、B之间进行简单通信
     * 前提：使用Object的wait方法的话，必须包在sync同步锁代码块中，否则会报错
     * 线程A先执行，进入线程等待，等待线程B去通知
     */
    @Test
    public void waitAndNotify() throws InterruptedException {
        // 子线程A
        new Thread(() -> {
            // 两个线程使用的同步锁对象需要一致，否则不会影响两个同步代码块执行的先后顺序
            synchronized (o) {
                try {
                    log.info("打印主线程，name = {}", Thread.currentThread().getName());
                    // 释放当前对象锁，然后进入线程阻塞等待
                    o.wait();
                    log.info("主线程等待完毕，执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        // 主线程休眠，目的是让A线程先执行
        TimeUnit.SECONDS.sleep(1);

        // 子线程B
        new Thread(() -> {
            // 线程B稍慢执行，所以需要等待线程A去释放o对象锁（同步代码块执行完毕或调用o.wait()方法）
            synchronized (o) {
                log.info("打印子线程，name = {}", Thread.currentThread().getName());
                // 通知等待的某个对象，若有多个，则会按照自身某种策略方式
                // 也可以使用notifyAll()，通知全部，哪个先拿到就先执行
                o.notify();
            }
        }, "B").start();
        TimeUnit.SECONDS.sleep(6);
    }

    /**
     * notifyAll()，会通知所有的对象等待
     */
    @Test
    public void waitAndNotifyAll() throws InterruptedException {
        // 子线程A
        new Thread(() -> {
            // 两个线程使用的同步锁对象需要一致，否则不会影响两个同步代码块执行的先后顺序
            synchronized (o) {
                try {
                    log.info("打印当前线程，name = {}", Thread.currentThread().getName());
                    // 释放当前对象锁，然后进入线程阻塞等待
                    o.wait();
                    log.info("执行结束，打印当前线程，name = {}", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        // 子线程C
        new Thread(() -> {
            // 两个线程使用的同步锁对象需要一致，否则不会影响两个同步代码块执行的先后顺序
            synchronized (o) {
                try {
                    log.info("打印当前线程，name = {}", Thread.currentThread().getName());
                    // 释放当前对象锁，然后进入线程阻塞等待
                    o.wait();
                    log.info("执行结束，打印当前线程，name = {}", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        // 主线程休眠，目的是让A线程先执行
        TimeUnit.SECONDS.sleep(1);

        // 子线程B
        new Thread(() -> {
            // 线程B稍慢执行，所以需要等待线程A去释放o对象锁（同步代码块执行完毕或调用o.wait()方法）
            synchronized (o) {
                log.info("打印当前线程，name = {}", Thread.currentThread().getName());
                // 通知等待的某个对象，若有多个，则会按照自身某种策略方式
                // 也可以使用notifyAll()，通知全部，哪个先拿到就先执行
                o.notifyAll();
            }
        }, "B").start();
        TimeUnit.SECONDS.sleep(6);
    }

    // ------------------- sync、wait()、notify()、notifyAll() 组合 -------------------------


}
