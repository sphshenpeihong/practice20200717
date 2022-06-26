package com.sph.practice.test.juc.integertest;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class IntegerAsyncTest {

    /**
     *
     */
    @Test
    public void test() throws InterruptedException {
        for (int i = 1; i <= 1000; i++) {
            new Thread(new InnerClass4(), String.valueOf(i)).start();
        }
        TimeUnit.SECONDS.sleep(3);
    }

}
