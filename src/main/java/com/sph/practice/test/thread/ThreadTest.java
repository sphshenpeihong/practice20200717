package com.sph.practice.test.thread;

import com.sph.practice.test.thread.utils.ThreadPoolUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Shen Peihong on 2020/6/16 2:19
 * 使用线程池 工具类去开启线程
 */

public class ThreadTest {

    private static ThreadPoolUtils tpu = new ThreadPoolUtils(20, 20, 1000, 10000, "通讯录回调");

    private static ReentrantLock reentrantLock = new ReentrantLock();
    //声明成static的，卖票问题需要共用同一把锁
    //private static Object lock = new Object();

    //电影票
    private static Integer ticket = 100;

    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.out.println("当前票剩下："+ ticket-- +"张");
        };

        for (int i=0;i<100;i++){
            try {
                //加了同步锁
                reentrantLock.lock();
                tpu.getThreadPool().execute(runnable);//该线程里面容易发生线程安全问题，就在外围锁住，如有必要，可在里面锁住
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();//防止try里面的代码有异常，导致不继续往下走，导致锁一直不解开
                //所以就为了防止无论try里面的代码有没有异常，最后都会执行finally
            }
        }

    }

}
