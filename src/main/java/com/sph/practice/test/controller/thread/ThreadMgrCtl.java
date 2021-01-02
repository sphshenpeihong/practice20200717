package com.sph.practice.test.controller.thread;

import com.sph.practice.mybatis.service.IClassService;
import com.sph.practice.mybatis.util.ApplicationContextUtil;
import com.sph.practice.test.thread.ThreadStartTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Shen Peihong on 2020/12/24 21:52
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/thread/mgr")
public class ThreadMgrCtl {

    @RequestMapping("/test1.do")
    public void test1(){

        new ThreadStartTest("123");
        //创建线程对象并开启
        Runnable thread = new ThreadClass();

        new Thread(thread).start();
    }

}


class ThreadClass implements Runnable{

    private RedisTemplate redisTemplate;

    private IClassService classService;
    public ThreadClass(){
        classService = ApplicationContextUtil.getBean("classService", IClassService.class);
        redisTemplate = ApplicationContextUtil.getBean("redisTemplate", RedisTemplate.class);
    }

    @Override
    public void run() {
        //开启线程，新建线程对象，但是线程对象里面的成员变量却注入不进来，
        System.out.println(Thread.currentThread().getName());
    }
}