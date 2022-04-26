package com.sph.practice.test.sebase.juc;

import org.junit.Test;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class AtomicIntegerTest1 {

    private Integer count = 0;

    /**
     *
     */
    @Test
    public void test() {
        // 两个线程同时操作一个变量时，可能两个线程同时读取到100，然后执行自增 101
        for (int i = 0; i < 5; i++) {
            System.out.println(count++);
        }
    }

}
