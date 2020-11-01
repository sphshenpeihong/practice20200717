package com.sph.practice.test.markdown.thread;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/10/30 3:08
 * Description:
 *
 * @since 1.0.0
 */
public class ABCTest {
    //测试A->B->C 依次循环打印问题

    /**
     *
     */
    @Test
    public void test(){
        ABC abc = new ABC();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                abc.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                abc.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                abc.printC();
            }
        }, "C").start();
    }


}
