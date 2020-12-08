package com.sph.practice.test.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2020/12/7 21:25
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/mgr/redis")
public class RedisTemplateCtl {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/test1.do")
    public void test1(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        for (int i = 0; i < 10; i++) {
            Long username = valueOperations.increment("username", 1L);
            System.out.println("打印当前：username = " + username);
        }
    }

    @RequestMapping("/test2.do")
    public void test2(){

    }

    @RequestMapping("/test3.do")
    public void test3(){

    }

    @RequestMapping("/test4.do")
    public void test4(){

    }

    @RequestMapping("/test5.do")
    public void test5(){

    }

    @RequestMapping("/test6.do")
    public void test6(){

    }

    @RequestMapping("/test7.do")
    public void test7(){

    }

    @RequestMapping("/test8.do")
    public void test8(){

    }

    @RequestMapping("/test9.do")
    public void test9(){

    }

    @RequestMapping("/test10.do")
    public void test10(){

    }

    @RequestMapping("/test11.do")
    public void test11(){

    }




}
