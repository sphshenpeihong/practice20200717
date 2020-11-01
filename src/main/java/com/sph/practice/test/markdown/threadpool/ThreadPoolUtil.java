package com.sph.practice.test.markdown.threadpool;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Shen Peihong on 2020/10/29 17:14
 * Description:线程池
 *
 * @since 1.0.0
 */
public class ThreadPoolUtil {
    /*
        public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             threadFactory, defaultHandler);
    }
     */
    //最大核心线程数
    private int corePoolSize;
    //最大
    private int maximumPoolSize;
    private long keepAliveTime;
    //private TimeUnit unit,
    private BlockingQueue<Runnable> workQueue;
    private ThreadFactory threadFactory;

    /**
     *
     */
    @Test
    public void test1(){
        //new ThreadPoolExecutor()
    }


}
