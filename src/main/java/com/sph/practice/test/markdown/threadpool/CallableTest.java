package com.sph.practice.test.markdown.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by Shen Peihong on 2020/11/2 23:04
 * Description:
 *
 * @since 1.0.0
 */
public class CallableTest implements Callable<Integer> {
    private static int num = 0;

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
            CallableTest thread = new CallableTest();
            //支持返回值的线程只支持实现Callable接口呢
            Future<Integer> submit = instance.submit(thread); //每个线程交给线程池去跑完后，会返回返回值
            TimeUnit.SECONDS.sleep(1);
        }
        TimeUnit.SECONDS.sleep(10);
    }


    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return num++;
    }

}
