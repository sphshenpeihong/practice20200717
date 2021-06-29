package com.sph.practice.test.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 尝试各种方法解决卖票问题
 * <p>
 * 20210624
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Slf4j
public class TicketQuestion {

    private static volatile AtomicInteger ticket = new AtomicInteger(100);

    private volatile static Integer integer = 100;

    /**
     * 不使用锁，多线程运行下，由于JMM模型，无法去同步到共享内存
     */
    @Test
    public void test1() throws InterruptedException {
        // 三个线程
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                //log.info("买票成功，当前票的剩余量为：" + ticket.getAndDecrement());
                System.out.println("A，买票成功，当前票的剩余量为：" + ticket.getAndDecrement());
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                //log.info("买票成功，当前票的剩余量为：" + ticket.getAndDecrement());
                System.out.println("B，买票成功，当前票的剩余量为：" + ticket.getAndDecrement());
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                //log.info("买票成功，当前票的剩余量为：" + ticket.getAndDecrement());
                System.out.println("C，买票成功，当前票的剩余量为：" + ticket.getAndDecrement());
            }
        }, "C").start();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void test2() throws InterruptedException {
        // 三个线程
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                //log.info("买票成功，当前票的剩余量为：" + ticket.getAndDecrement());
                System.out.println("A，买票成功，当前票的剩余量为：" + integer--);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                //log.info("买票成功，当前票的剩余量为：" + ticket.getAndDecrement());
                System.out.println("B，买票成功，当前票的剩余量为：" + integer--);
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                //log.info("买票成功，当前票的剩余量为：" + ticket.getAndDecrement());
                System.out.println("C，买票成功，当前票的剩余量为：" + integer--);
            }
        }, "C").start();
        TimeUnit.SECONDS.sleep(2);
    }


}
