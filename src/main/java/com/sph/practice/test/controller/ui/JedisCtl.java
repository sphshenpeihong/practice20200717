package com.sph.practice.test.controller.ui;

import com.sph.practice.test.jedis.JedisTemplateTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by Shen Peihong on 2020/9/14 22:45
 * Description: JedisTemplate工具类的使用，相关配置采用Springboot整合redis自动配置
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/mgr/cache")
public class JedisCtl {

    //不能用static，因为如果用static声明的话，凡是Spring容器注入的变量，都不能使用static声明
    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/test1.do")
    public void test1(){
        JedisTemplateTest jedisTemplateTest = new JedisTemplateTest();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        /*valueOperations.set("username","123123");
        System.out.println(valueOperations.get("username"));*/
    }
}
