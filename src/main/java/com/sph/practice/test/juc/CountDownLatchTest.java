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
     * CountDownLatch  减法计数器
     */
    @Test
    public void countDownLatchTest() throws InterruptedException {
        // 初始化计数器数量
        CountDownLatch countDownLatch = new CountDownLatch(2);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("打印：" + Thread.currentThread().getName());
                // 计数器自减
                countDownLatch.countDown();
            }, "A").start();
        }
        // 当计数器减到为0时，才往下继续执行，否则一直开启等待
        countDownLatch.await();
        System.out.println("计算器减到为0了");
    }

}
