package com.sph.practice.test.juc.completableFuture;

import com.sph.practice.test.thread.utils.ThreadPoolUtils;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture工具类（也是线程执行器，运用的也是静态代理模式）
 *
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/5/12
 */
public class CompletableFutureTest {

    // 自定义线程池
    // private static Executor = new ThreadPoolUtils()



    // runSync
    @Test
    public void runSync() throws InterruptedException {


        CompletableFuture.runAsync(() -> {
           System.out.println("打印当前线程：" + Thread.currentThread().getName());
        });
        System.out.println("当前是主线程：" + Thread.currentThread().getName());
        Thread.sleep(10000);
    }

    // supplierSync
    @Test
    public void supplierSync() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
                System.out.println("打印当前线程：" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "OK";
        });
        // System.out.println(future.get());
        System.out.println(future.join());
        System.out.println("当前是主线程：" + Thread.currentThread().getName());
        Thread.sleep(5000);
    }

}
