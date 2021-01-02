package com.sph.practice.test.thread;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Created by Shen Peihong on 2020/12/24 21:49
 * Description: 写一个线程 线程r
 *
 * @since 1.0.0
 */
public class ThreadStartTest extends ParantThread {




    public ThreadStartTest(String str){
        System.out.println("子");
    }

    /**
     *
     */
    @Test
    public void test(){
        new ThreadStartTest("123");
    }


}


