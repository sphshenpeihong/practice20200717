package com.sph.practice.test.markdown.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Shen Peihong on 2020/10/29 17:14
 * Description:封装线程池对象方法
 *
 * @since 1.0.0
 */
public class ThreadPoolUtil {
    //核心线程数
    private int corePoolSize;
    //最大线程数 (正式工+临时工)
    private int maximumPoolSize;
    //排队空闲线程的存活时间，到点未转成任务线程的话会被拒绝策略所拒绝
    private long keepAliveTime;
    //上面参数的单位
    private TimeUnit unit;
    //队列
    private BlockingQueue<Runnable> workQueue;
    //队列长度
    private int queueSize;
    //线程工厂
    private ThreadFactory threadFactory;

    //提供线程池对象实例
    //默认创建线程池
    public ThreadPoolExecutor getInstance() {
        corePoolSize = 10;
        maximumPoolSize = 100;
        keepAliveTime = 3;
        unit = TimeUnit.SECONDS;
        queueSize = 1000;
        workQueue = new ArrayBlockingQueue<Runnable>(queueSize); //实现类已经去实现完接口定义的方法了
        threadFactory = new ThreadFactory() {
            private AtomicInteger currentNum = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                System.out.println("新创建线程成功,当前序号为：" + currentNum.getAndIncrement());
                return new Thread(r);
            }
        };
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    //提供自己指定最大核心线程数与最大线程数的构造方法
    public ThreadPoolExecutor getInstance(int corePoolSize, int maximumPoolSize) {

        keepAliveTime = 300;
        unit = TimeUnit.SECONDS;
        queueSize = 1000;
        workQueue = new ArrayBlockingQueue<Runnable>(queueSize); //实现类已经去实现完接口定义的方法了
        threadFactory = new ThreadFactory() {
            private AtomicInteger currentNum = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                System.out.println("新创建线程成功,当前序号为：" + currentNum.getAndIncrement());
                return new Thread(r);
            }
        };

        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

}
