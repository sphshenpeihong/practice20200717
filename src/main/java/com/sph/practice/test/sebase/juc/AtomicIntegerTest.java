package com.sph.practice.test.sebase.juc;

import org.junit.Test;

/**
 * 测试AtomicInteger原子类的一些方法，以及方法底层的思想
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class AtomicIntegerTest {

    public static Integer i = 0;

    /**
     *
     */
    @Test
    public void test() throws InterruptedException {
        new ProductThread().start();
        new ConsumerThread().start();
        Thread.sleep(10000);
    }

    // 写两个线程，死循环，同时去读一个Integer类型的资源，然后看看同时读，在多线程并发操作下，会发生什么

    private static final int THREADS_CONUT = 20;
    public volatile static int count = 0;

    public static void increase() {
        count++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(count);
    }


}

class ProductThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("product：" + AtomicIntegerTest.i++);
        }

    }
}

class ConsumerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("consumer：" + AtomicIntegerTest.i--);
        }

    }
}
