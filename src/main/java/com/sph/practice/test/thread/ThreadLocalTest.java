package com.sph.practice.test.thread;

import com.sph.practice.test.markdown.threadpool.ThreadPoolUtil;
import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Shen Peihong on 2020/12/23 22:47
 * Description: 试试ThreadLocal 线程的本地存储
 *
 * @since 1.0.0
 */
public class ThreadLocalTest {
    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 开启两个线程，做相同的累加操作。分别存值与取值
     */
    @Test
    public void test1() throws InterruptedException {
        //两个线程 ，循环存值，然后存完取值，看看互相会不会影响到

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    //存值
                    THREAD_LOCAL.set(i);
                    //取值
                    System.out.println(Thread.currentThread().getName() + "：" + THREAD_LOCAL.get());
                }
            } finally {
                //THREAD_LOCAL里面的静态内部类Entry是弱引用，理论上该线程结束后，GC会自动回收
                //但一般我们自己手动清除
                THREAD_LOCAL.remove();
            }
        }, "shen").start();
        Thread.sleep(1000);

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    //存值
                    THREAD_LOCAL.set(i);
                    //取值
                    System.out.println(Thread.currentThread().getName() + "：" + THREAD_LOCAL.get());
                }
            } finally {
                //THREAD_LOCAL里面的静态内部类Entry是弱引用，理论上该线程结束后，GC会自动回收
                //但一般我们自己手动清除
                THREAD_LOCAL.remove();
            }
        }, "lin").start();
        Thread.sleep(3000);
    }


    //专门使用线程本地存储，和定义局部变量的区别是啥呢？

    /**
     * 不用ThreadLocal去存储值 使用局部变量试试
     */
    @Test
    public void test2() throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "打印取值：" + i);
            }
        }, "shen").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "打印取值：" + i);
            }
        }, "lin").start();
        Thread.sleep(3000);
        System.out.println("打印一下");
    }

    /**
     * 写个线程，放到线程池中运行，线程池的最大核心数设置成1，线程里面睡1秒，然后做累加操作。等待的线程看看会不会仍有该值
     */
    @Test
    public void test3() throws InterruptedException {
        ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
        ThreadPoolExecutor instance = threadPoolUtil.getInstance(1, 1);
        instance.execute(()->{
            try {
                THREAD_LOCAL.set(666);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                THREAD_LOCAL.remove();
            }
        });
        instance.execute(()->{
            try {
                System.out.println("先获取看看有无值：" + THREAD_LOCAL.get());
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(1000000);
    }
}

