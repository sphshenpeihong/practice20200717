package com.sph.practice.component.boot.service.impl;

import com.sph.practice.component.boot.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/5/12
 */
@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {

    // 这个方法被调用的时候，不同步执行，而是异步去执行
    @Override
    @Async("threadPoolTaskExecutor")
    public void async() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("我是使用了Springboot提供注解的线程池去异步执行的");
    }
}
