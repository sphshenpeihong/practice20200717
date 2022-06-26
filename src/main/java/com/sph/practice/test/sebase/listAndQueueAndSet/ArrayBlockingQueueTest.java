package com.sph.practice.test.sebase.listAndQueueAndSet;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Shen Peihong on 2021/1/22
 * Description: 线程中的生产者-消费者模式
 *
 * @since 1.0.0
 */
public class ArrayBlockingQueueTest {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue(1);

    private static AtomicInteger integer = new AtomicInteger();

    //生产者
    class ProductThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // 添加一个元素 如果队列满，则阻塞
                    queue.put(integer.incrementAndGet());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者1
    class ConsumeThread1 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("阻塞1？");
                    Thread.sleep(1000);
                    // 移除并返回队列头部的元素 如果队列为空，则阻塞
                    Integer val = queue.take();
                    System.out.println("消费者1进行取值：" + val);
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者2
    class ConsumeThread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("阻塞2？");
                    // 移除并返回队列头部的元素 如果队列为空，则阻塞
                    Integer val = queue.take();
                    System.out.println("消费者2进行取值：" + val);
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     */
    @Test
    public void test() throws InterruptedException {
        //开启生产者-消费者线程
        new ProductThread().start();
        new ConsumeThread1().start();
        new ConsumeThread2().start();
        Thread.sleep(1000000);
    }

}








