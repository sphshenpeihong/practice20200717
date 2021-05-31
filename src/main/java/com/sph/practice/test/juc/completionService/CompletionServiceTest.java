package com.sph.practice.test.juc.completionService;

import com.google.common.collect.Lists;
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
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            for (Future future : futureList) {
                future.cancel(true);
            }
        }
        Thread.sleep(2000);

    }

    private String NoOne() throws InterruptedException {
        Thread.sleep(1000);
        return "1：" + "我是小一";
    }

    private String NoTwo() throws InterruptedException {
        Thread.sleep(1100);
        return "2：" + "我是小二";
    }

    private String NoThree() throws InterruptedException {
        Thread.sleep(1200);
        return "3：" + "我是小三";
    }
}
/*
    最终输出：
            1：我是小一
            2：我是小二
            3：我是小三
 */