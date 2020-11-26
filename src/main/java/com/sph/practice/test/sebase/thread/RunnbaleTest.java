package com.sph.practice.test.sebase.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Shen Peihong on 2020/11/2 1:33
 * Description:
 *
 * @since 1.0.0
 */
public class RunnbaleTest {

    @Test
    public void test() throws InterruptedException {
        new Thread(new MyThread(),"A").start();
        new Thread(new MyThread(),"B").start();
        TimeUnit.SECONDS.sleep(1);
    }


class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("run1");
    }
}

}
