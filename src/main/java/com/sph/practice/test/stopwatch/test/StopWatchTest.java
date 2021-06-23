package com.sph.practice.test.stopwatch.test;

import org.junit.Test;
import org.springframework.util.StopWatch;
import org.json.Cookie;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
public class StopWatchTest {

    /**
     * 简单测试一下StopWatch工具类 （Spring）
     */
    @Test
    public void test1() throws InterruptedException {
        StopWatch sw = new StopWatch("结果上传");
        sw.start("task1");
        Thread.sleep(101);
        sw.stop();
        sw.start("task2");
        Thread.sleep(200);
        sw.stop();
        // 打印每个任务详细的时间，时间以"ns"级别
        System.out.println(sw.prettyPrint());
        // 计算任务执行的总时间（ms）
        System.out.println(sw.getTotalTimeMillis());
        /*
            StopWatch '结果上传': running time = 300549600 ns
            ---------------------------------------------
            ns         %     Task name
            ---------------------------------------------
            100150200  033%  task1
            200399400  067%  task2

            300
         */
    }

}
