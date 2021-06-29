package com.sph.practice.test.semaphore;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Slf4j
public class SemaphoreTest {

    /**
     * 简单测试Semaphore信号量的使用
     */
    @Test
    public void test() throws InterruptedException {
        // 开5个线程，获取到信号量的才能执行，没获取到的需要等待
        // for循环开启5个线程去执行业务
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 5; i++) {
            // 开启线程
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    log.info("打印当前线程，name = {}", Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(2);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(12);
    }

}
