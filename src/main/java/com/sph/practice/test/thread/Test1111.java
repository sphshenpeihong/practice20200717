package com.sph.practice.test.thread;

import com.sph.practice.test.thread.utils.ThreadPoolUtils;
import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shen Peihong on 2020/12/24 22:34
 * Description:
 *
 * @since 1.0.0
 */
public class Test1111 {

    private static ThreadPoolUtils tpu = new ThreadPoolUtils(0, 20, 1000, 10000, "通讯录回调");

    /**
     *
     */
    @Test
    public void test1(){
        new ParantThread("123");
    }


    /**
     *
     */
    @Test
    public void test2() throws InterruptedException {
        ThreadPoolExecutor threadPool = tpu.getThreadPool();
        threadPool.submit(
                () -> {
                    System.out.println("我是子线程");
                }
                         );
        TimeUnit.SECONDS.sleep(100);
    }

}
