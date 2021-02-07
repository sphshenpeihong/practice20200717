package com.sph.practice.test.juc;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shen Peihong on 2021/2/7
 * Description: CountDownLatch 计数器，计算线程的
 *
 * @since 1.0.0
 */
public class CountDownLatchTest {

    /**
     *
     */
    @Test
    public void test1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("打印：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            }, "A").start();
        }
        countDownLatch.await();
        System.out.println("执行完了");
    }

}
