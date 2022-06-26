package com.sph.practice.test.sebase.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Shen Peihong on 2020/11/2 1:33
 * Description:
 *
 * @since 1.0.0
 */
public class RunnbaleTest {

    @Test
    public void test() throws InterruptedException {
        new Thread(new MyThread(), "A").start();
        new Thread(new MyThread(), "B").start();
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * 两个不同的线程，看看线程的名称
     */
    @Test
    public void test1() throws InterruptedException {
        new Thread(() -> {System.out.println(Thread.currentThread().getName());}).start();
        new Thread(() -> {System.out.println(Thread.currentThread().getName());}).start();
        TimeUnit.SECONDS.sleep(2);

    }


    class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("run1");
        }
    }

}
