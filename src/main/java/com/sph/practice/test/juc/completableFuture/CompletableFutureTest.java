package com.sph.practice.test.juc.completableFuture;

import com.sph.practice.component.exception.BaseException;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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



    // runSync ： 异步 无返回值
    @Test
    public void runSync() throws InterruptedException {

        // Runnbale接口，无返回值
        CompletableFuture.runAsync(() -> {
           System.out.println("打印当前线程：" + Thread.currentThread().getName());
        });
        System.out.println("当前是主线程：" + Thread.currentThread().getName());
        Thread.sleep(10000);
    }

    // supplierSync ： 异步，但是一旦你使用了join()或get()方法，就会阻塞调用方的线程了，这样一来俩个线程都没执行完毕了。有返回值
    @Test
    public void supplierSync() throws InterruptedException, ExecutionException {
        // 生产补给接口，有返回值（类似Callable）
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

    // supplierSync ： 测试join方法和get方法的区别
    @Test
    public void supplierSync1() throws InterruptedException, ExecutionException {
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
        Thread.sleep(10000);
    }

    // thenApplyAsync() ： 异步回调 不阻塞原调用方线程
    // thenApply()与上面的区别就是一个有用线程池，一个没用到线程池
    @Test
    public void thenApply() throws InterruptedException {
        // 异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("打印future1，" + Thread.currentThread().getName());
            return "123";
        });
        // 提供回调函数机制，不会去阻塞main线程
        CompletableFuture<Integer> future2 = future1.thenApplyAsync(v -> {
            System.out.println("打印future2，" + Thread.currentThread().getName());
            return Integer.parseInt(v);
        });
        System.out.println("打印主线程，" + Thread.currentThread().getName());
        Thread.sleep(5000);
        /*
            打印主线程，main
            打印future1，ForkJoinPool.commonPool-worker-1
            打印future2，ForkJoinPool.commonPool-worker-1
            // 执行回调函数的时候，仍然用原来的异步线程，不会另起炉灶开新线程
         */
    }

    // thenAccept() ： 也支持异步回调函数，不过这个没有返回值
    @Test
    public void thenAccept() throws InterruptedException {
        // 异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (true) {
                throw new RuntimeException();
            }
            System.out.println("打印future1，" + Thread.currentThread().getName());
            return "123";
        });
        // 回调函数
        future1.thenAcceptAsync(v -> {
            System.out.println("打印future2，" + Thread.currentThread().getName());
        });
        System.out.println("打印主线程，" + Thread.currentThread().getName());
        Thread.sleep(5000);
        /*
            打印主线程，main
            打印future1，ForkJoinPool.commonPool-worker-1
            打印future2，ForkJoinPool.commonPool-worker-1
         */
    }

    // thenRunAsync() ： 无入参，无返回值
    @Test
    public void thenRunAsync() throws InterruptedException {
        // 异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("打印future1，" + Thread.currentThread().getName());
            return "123";
        });
        CompletableFuture<Void> future2 = future1.thenRunAsync(() -> {
            System.out.println("打印future2，" + Thread.currentThread().getName());
        });
        System.out.println("打印主线程，" + Thread.currentThread().getName());
        Thread.sleep(5000);
        /*
            打印主线程，main
            打印future1，ForkJoinPool.commonPool-worker-1
            打印future2，ForkJoinPool.commonPool-worker-1
         */
    }

    // thenCompose() ： 两个异步任务有依赖关系
    @Test
    public void thenCompose() throws InterruptedException, ExecutionException {
        // 异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("打印future1，" + Thread.currentThread().getName());
            return "123";
        });
        CompletableFuture<String> future2 = future1.thenComposeAsync(value -> {
            System.out.println("打印future2，" + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("打印future3，" + Thread.currentThread().getName());
                return value + "456";
            });
        });
        System.out.println(future2.get());
        Thread.sleep(4000);
    }

    // exceptionlly()  对异步任务，捕捉异常，然后进行处理
    @Test
    public void excepionlly() throws InterruptedException {
        // 异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("打印future1，" + Thread.currentThread().getName());
            return "123";
        }).exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });
        Thread.sleep(3000);
    }

}
