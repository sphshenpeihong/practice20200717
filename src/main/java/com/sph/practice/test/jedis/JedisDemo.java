package com.sph.practice.test.jedis;

import com.sph.practice.test.jedis.utils.JedisClient;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Shen Peihong on 2020/9/14 20:12
 * Description: jedis 小demo
 *
 * @since 1.0.0
 */
public class JedisDemo {

    /**
     * 直接新建jedis对象，操作jedis实例
     */
    @Test
    public void test(){
        //直接新建jedis对象，操作jedis实例
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("username","123");
        System.out.println(jedis.get("username"));
    }

    /**
     * 初始化redis连接池，从redis连接池拿出对象
     */
    /**
     *
     */
    @Test
    public void test1(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500);
        config.setMaxIdle(100);
        config.setMinIdle(10);
        JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("username","666");
        System.out.println(jedis.get("username"));
    }

    /**
     * 通过jedis工具类，进而从Jedis连接池获得jedis对象
     */
    @Test
    public void test2(){
        Jedis jedis = JedisClient.getClient();
        jedis.set("username","123");
        System.out.println(jedis.get("username"));
    }

}
