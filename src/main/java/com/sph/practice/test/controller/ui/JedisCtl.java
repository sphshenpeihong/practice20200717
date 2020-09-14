package com.sph.practice.test.controller.ui;

import com.google.common.collect.Lists;
import com.sph.practice.test.jedis.JedisTemplateTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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


    /**
     * 利用redisTemplate的直接方法，测试删除key、keys  然后判断key是否存在
     */
    @RequestMapping("/test1.do")
    public void test1(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("username","123123");
        valueOperations.set("zhangsan","123123");
        valueOperations.set("lisi","123123");
        System.out.println(valueOperations.get("username"));
        System.out.println("redis缓存中的key为：username，是否存在？答案是：" + redisTemplate.hasKey("username"));//判断key是否存在
        redisTemplate.delete("username");//删除redis中该key
        System.out.println("redis缓存中的key为：username，是否存在？答案是：" + redisTemplate.hasKey("username"));//判断key是否存在

        //批量删除keys
        System.out.println("redis缓存中的key为：zhangsan，是否存在？答案是：" + redisTemplate.hasKey("zhangsan"));
        System.out.println("redis缓存中的key为：lisi，是否存在？答案是：" + redisTemplate.hasKey("lisi"));
        redisTemplate.delete(Lists.newArrayList("zhangsan","lisi"));//批量删除keys
        System.out.println("redis缓存中的key为：zhangsan，是否存在？答案是：" + redisTemplate.hasKey("zhangsan"));
        System.out.println("redis缓存中的key为：lisi，是否存在？答案是：" + redisTemplate.hasKey("lisi"));
    }

    /**
     * 设置一个key的过期时间
     * @throws InterruptedException
     */
    @RequestMapping("/test2.do")
    public void test2() throws InterruptedException {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("username","123456");
        System.out.println("现在是否存在：" + redisTemplate.hasKey("username"));
        Boolean hasKeyOfUsername = redisTemplate.hasKey("username");//判断key是否存在
        redisTemplate.expire("username", 100, TimeUnit.MILLISECONDS);//指定该Key的有效时间为100毫秒
        Thread.sleep(100); //100毫秒
        System.out.println("现在是否存在：" + redisTemplate.hasKey("username"));
    }

    /**
     * 获取一个key的过期时间
     * @throws InterruptedException
     */
    @RequestMapping("/test3.do")
    public void test3() throws InterruptedException {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("username","123456");
        redisTemplate.expire("username", 1001, TimeUnit.SECONDS);
        System.out.println("获取key为username的过期时间为：" + redisTemplate.getExpire("username"));
        Long expireTime = redisTemplate.getExpire("username");//获取该Key的过期时间，时间单位为秒，小于1秒的话直接值为0
    }


}
