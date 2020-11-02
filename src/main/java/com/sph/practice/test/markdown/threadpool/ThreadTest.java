package com.sph.practice.test.markdown.threadpool;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by Shen Peihong on 2020/10/29 21:38
 * Description:线程类
 *
 * @since 1.0.0
 */
public class ThreadTest implements Runnable, Callable<Integer> {
    private static int num = 0;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("线程类执行打印语句," + "当前的线程对象的名字叫：" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * 使用自定义线程池去跑线程
     */
    @Test
    public void test(){
        ThreadPoolExecutor instance = new ThreadPoolUtil().getInstance();//创建线程池对象
        ThreadTest thread = new ThreadTest();//创建线程对象
        instance.execute(thread);//线程池对象里面提供了跑线程的方法，只需要将线程对象放入线程池中执行即可
    }

    @Test
    public void test1() throws InterruptedException {
        ThreadPoolExecutor instance = new ThreadPoolUtil().getInstance();//创建线程池对象
        for (int i = 0; i < 10; i++) {
            ThreadTest thread = new ThreadTest();
            instance.execute(thread);//本次线程代码执行完毕
        }
        TimeUnit.SECONDS.sleep(10);
    }
    //现象复盘
    //由于最大核心线程数是2，所以最多可以创建两个线程去
    //循环跑10次线程，最大核心线程数是2，存活时间1秒，最大线程数为5，有界队列为8，
    /**
     * 等会测试一下，新建2个核心线程，最大线程数5，有界队列设置15(看看队列的长度会不会受到最大线程数的约束)，线程工厂创建线程时，打印初当前线程名字，以及数字序号, 循环10使用线程池去开启线程
     */
    @Test
    public void test2() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor instance = new ThreadPoolUtil().getInstance();//创建线程池对象
        for (int i = 0; i < 10; i++) {
            ThreadTest thread = new ThreadTest();//创建线程对象
            Future<Integer> submit = instance.submit((Callable<Integer>) thread);
            System.out.println(submit.get());
        }
        TimeUnit.SECONDS.sleep(10);

    }


    @Override
    public Integer call() throws Exception {
        return num++;
    }
}
