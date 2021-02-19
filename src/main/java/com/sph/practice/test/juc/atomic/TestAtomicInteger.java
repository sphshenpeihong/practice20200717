package com.sph.practice.test.juc.atomic;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by Shen Peihong on 2021/2/9
 * Description: AtomicInteger
 *
 * @since 1.0.0
 */
public class TestAtomicInteger {

    /**
     * AtomicInteger
     */
    @Test
    public void test1() {
        // 原子类，在自增或计数相关的操作保证了原子性操作
        // 底层机制：CAS
        // 底层操作：自旋锁
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 30; i++) {
            System.out.println(atomicInteger.getAndIncrement());
        }
    }

        /**
         * 可能会出现ABA问题，我们不希望发生这种问题
         * 需要使用原子引用，里面提供了版本号(乐观锁的思想)
         */
        @Test
        public void test2() throws InterruptedException {
            AtomicStampedReference<Integer> reference = new AtomicStampedReference<Integer>(2020, 0);
            // 开启两个线程，线程1执行，线程2后执行，线程2发现版本号不对劲的话，打印出文本
            new Thread(() -> {
                int stamp1 = reference.getStamp();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                boolean flag1 = reference.compareAndSet(2020, 2021, stamp1, stamp1 + 1);
                System.out.println("flag1 = " + flag1);
                System.out.println("value1 = " + reference.getReference());

                int stamp2 = reference.getStamp();
                boolean flag2 = reference.compareAndSet(2021, 2020, stamp2, stamp2 + 1);
                System.out.println("flag2 = " + flag2);
                System.out.println("value2 = " + reference.getReference());
            }, "A").start();

            new Thread(() -> {
                int stamp1 = reference.getStamp();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 由于版本号判断当前版本号已不对的话，不会完成期望值修改
                boolean flag3 = reference.compareAndSet(2020, 666, stamp1, stamp1 + 1);
                System.out.println("flag3 = " + flag3);
                System.out.println("value3 = " + reference.getReference());

            }, "B").start();
            TimeUnit.SECONDS.sleep(2);
        }

    /**
     * 原子引用类型
     */
    @Test
    public void test3() {
        AtomicReference<Integer> reference = new AtomicReference<>(1);
        boolean b = reference.compareAndSet(1, 2);
        System.out.println(b);
        System.out.println(reference.get());
    }


}
