package com.sph.practice.component.boot.controller;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
@RestController
@RequestMapping("/completableFuture")
public class CompletableFutureCtl {

    @RequestMapping("/thenAccept")
    public void thenAccept() throws InterruptedException {
        // 异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (true) {
                System.out.println("异常了");
                throw new RuntimeException();
            }
            System.out.println("打印future1，" + Thread.currentThread().getName());
            return "123";
        });
        // 回调函数
/*        future1.thenCompl(v -> {
            System.out.println("打印future2，" + Thread.currentThread().getName());
        });*/
        System.out.println("打印主线程，" + Thread.currentThread().getName());
        /*
            打印主线程，main
            打印future1，ForkJoinPool.commonPool-worker-1
            打印future2，ForkJoinPool.commonPool-worker-1
         */
    }

}
