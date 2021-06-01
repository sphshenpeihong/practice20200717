package com.sph.practice.test.juc.completionService;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * CompletionService 异步处理引入了队列，多个线程执行情况下，可以使用
 *
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/5/13
 */
@Slf4j
public class CompletionServiceTest {

    /**
     * 书写三个方法，各自返回不同的String
     * 创建三个线程任务，然后使用CompletionService去执行，for循环获取队列的Future，看看哪个先执行完
     * 具体线程执行的快慢，利用线程休眠
     */
    @Test
    public void test() throws InterruptedException {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService cs = new ExecutorCompletionService(executorService);
        // 提交三个线程任务
        Future future1 = cs.submit(this::NoOne);
        Future future2 = cs.submit(this::NoTwo);
        Future future3 = cs.submit(this::NoThree);
        List<Future> futureList = Lists.newArrayList(future1, future2, future3);
        // 循环获取队列中的结果
        try {
            for (int i = 0; i < 3; i++) {
                String str = (String) cs.take().get();
                log.info(Thread.currentThread().getName() + "：" + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            for (Future future : futureList) {
                future.cancel(true);
            }
        }
        log.info(Thread.currentThread().getName() + "：" + "Finish");
        Thread.sleep(2000);
    }

    /**
     * 主线程不阻塞，获取值处理也是异步的
     *
     * @throws InterruptedException
     */
    @Test
    public void test1() throws InterruptedException {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService cs = new ExecutorCompletionService(executorService);
        // 提交三个线程任务
        Future future1 = cs.submit(this::NoOne);
        Future future2 = cs.submit(this::NoTwo);
        Future future3 = cs.submit(this::NoThree);
        List<Future> futureList = Lists.newArrayList(future1, future2, future3);
        // 循环获取队列中的结果
        CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    String str = (String) cs.take().get();
                    log.info(Thread.currentThread().getName() + "：" + str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                for (Future future : futureList) {
                    future.cancel(true);
                }
            }
            log.info(Thread.currentThread().getName() + "：" + "Finish");
        });
        log.info(Thread.currentThread().getName() + "：" + "game over");
        Thread.sleep(2000);
    }

    private String NoOne() throws InterruptedException {
        Thread.sleep(1000);
        log.info(Thread.currentThread().getName() + "：" + 1);
        return "1：" + "我是小一";
    }

    private String NoTwo() throws InterruptedException {
        Thread.sleep(1100);
        log.info(Thread.currentThread().getName() + "：" + 2);
        return "2：" + "我是小二";
    }

    private String NoThree() throws InterruptedException {
        Thread.sleep(1200);
        log.info(Thread.currentThread().getName() + "：" + 3);
        return "3：" + "我是小三";
    }
}
/*
    test
    最终输出：
            1：我是小一
            2：我是小二
            3：我是小三
 */

/*
    test1
    最终输出：
[main] INFO com.sph.practice.test.juc.completionService.CompletionServiceTest - main：game over
[pool-1-thread-1] INFO com.sph.practice.test.juc.completionService.CompletionServiceTest - pool-1-thread-1：1
[ForkJoinPool.commonPool-worker-1] INFO com.sph.practice.test.juc.completionService.CompletionServiceTest - ForkJoinPool.commonPool-worker-1：1：我是小一
[pool-1-thread-2] INFO com.sph.practice.test.juc.completionService.CompletionServiceTest - pool-1-thread-2：2
[ForkJoinPool.commonPool-worker-1] INFO com.sph.practice.test.juc.completionService.CompletionServiceTest - ForkJoinPool.commonPool-worker-1：2：我是小二
[pool-1-thread-3] INFO com.sph.practice.test.juc.completionService.CompletionServiceTest - pool-1-thread-3：3
[ForkJoinPool.commonPool-worker-1] INFO com.sph.practice.test.juc.completionService.CompletionServiceTest - ForkJoinPool.commonPool-worker-1：3：我是小三
[ForkJoinPool.commonPool-worker-1] INFO com.sph.practice.test.juc.completionService.CompletionServiceTest - ForkJoinPool.commonPool-worker-1：Finish
 */
