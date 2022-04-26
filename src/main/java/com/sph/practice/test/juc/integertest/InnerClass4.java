package com.sph.practice.test.juc.integertest;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class InnerClass4 implements Runnable {

    static volatile int count = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：" + count++);
    }

}
