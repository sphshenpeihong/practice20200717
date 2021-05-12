package com.sph.practice.component.boot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定时任务，每三秒打印一条输出语句
 *
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/5/13
 */
@Component
public class PrintTask {

    private AtomicInteger integer = new AtomicInteger(0);

    // 每三秒打印一条输出语句
    @Scheduled(cron = "0/3 * * * * ? ")
    public void print() {
        System.out.println("定时任务开始执行啦" + integer.getAndIncrement());
    }

}
