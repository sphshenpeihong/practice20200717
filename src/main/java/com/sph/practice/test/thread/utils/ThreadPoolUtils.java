package com.sph.practice.test.thread.utils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Shen Peihong on 2020/6/16 0:36
 * 线程池工具类
 * 重点学习线程池类：ThreadPoolExecutor
 */

public class ThreadPoolUtils {
    //线程池核心线程数
    private int CORE_POOL_SIZE;
    //线程池最大线程数
    private int MAX_POOL_SIZE;
    //额外线程空状态生存时间
    private long KEEP_ALIVE_TIME;
    //队列长度
    private int QUEUE_SIZE;
    //告警的队列大小
    private int WARN_QUEUE_SIZE;
    //阻塞队列，当核心线程都被占用，且阻塞队列已满的情况下，才会开启额外线程
    private BlockingQueue<Runnable> workQueue = null;
    //线程池
    private ThreadPoolExecutor threadPool;
    //线程池名称
    private String POOL_NAME;

    public ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ThreadPoolExecutor threadPool) {
        this.threadPool = threadPool;
    }

    /**
     * 线程池工具类构造方法
     * @param corePoolSize 线程池核心线程数
     * @param maximumPoolSize 线程池最大线程数
     * @param keepAliveTime 额外线程空状态生存时间(毫秒)
     * @param queueSize 队列长度
     * @param poolName 线程池名称
     */
    public ThreadPoolUtils(int corePoolSize, int maximumPoolSize, long keepAliveTime, int queueSize, String poolName){
        //线程池核心线程数
        CORE_POOL_SIZE = corePoolSize;
        //线程池最大线程数
        MAX_POOL_SIZE = maximumPoolSize;
        //额外线程空状态生存时间
        KEEP_ALIVE_TIME = keepAliveTime;
        //队列长度
        QUEUE_SIZE = queueSize;
        //告警队列长度
        WARN_QUEUE_SIZE = (QUEUE_SIZE*2)/3;
        workQueue = new ArrayBlockingQueue<Runnable>(QUEUE_SIZE);
        //线程池名称
        POOL_NAME = poolName;
        //线程工厂 在线程池中负责开启线程的
        ThreadFactory threadFactory = new ThreadFactory() {
            private AtomicInteger integer = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"ThreadPool"+POOL_NAME+"thread:"+integer.getAndIncrement());
            }
        };
        threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.SECONDS, workQueue, threadFactory);//创建线程池

    }

}
