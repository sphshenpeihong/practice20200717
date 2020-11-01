package com.sph.practice.test.markdown.thread;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/10/30 2:15
 * Description:
 *
 * @since 1.0.0
 */
public class DataTest {

    /**
     *
     */
    @Test
    public void test(){
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }

}
