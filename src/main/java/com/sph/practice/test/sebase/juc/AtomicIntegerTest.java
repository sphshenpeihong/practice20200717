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
