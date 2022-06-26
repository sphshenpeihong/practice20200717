package com.sph.practice.test.sebase.juc;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class VolatileTest {

    private AtomicInteger count = new AtomicInteger(0);

    /**
     *
     */
    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(count.incrementAndGet());
            }).start();
        }

        TimeUnit.SECONDS.sleep(3);
    }

    /**
     *
     */
    @Test
    public void test1() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("121212");
    }


    /**
     *
     */
    @Test
    public void test2() {
        System.out.println("");
    }

}
