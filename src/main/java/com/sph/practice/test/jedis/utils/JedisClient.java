package com.sph.practice.test.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Shen Peihong on 2020/9/10 14:29
 * Description:初始化Jedis连接池
 *
 * @since 1.0.0
 */
public class JedisClient {

    private static JedisPool jedisPool;

    //static静态代码块，当类被加载时执行
    static {
        init();
    }

    //封装初始化jedis连接池方法
    private static void init(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500); //最大连接数  (长工+临时工)
        config.setMaxIdle(200); //最大空闲数  （长工）
        config.setMaxWaitMillis(5000); //等待可用连接最大时间，超过这个时间仍未获取到jedis实例的话，直接抛JedisConnectionException
        jedisPool = new JedisPool(config,"localhost",6379,1000);
    }

    //提供获得Jedis对象的静态方法
    public static Jedis getClient(){
        Jedis jedis = null;
        try {
             jedis = jedisPool.getResource();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jedis;
    }


}
