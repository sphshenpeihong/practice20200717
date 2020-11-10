package com.sph.practice.test.markdown.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Shen Peihong on 2020/11/9 21:41
 * Description:初始化Jedis连接池
 *
 * @since 1.0.0
 */
public class JedisClient {

    //Jedis连接池对象,需要初始化，不然连连接哪个redis服务器都不知道
    private static JedisPool jedisPool;

    static {
        //双重校验锁---单例实例化jedis连接池
        if (jedisPool == null){
            synchronized (JedisClient.class){
                if (jedisPool == null){
                    init();
                }
            }
        }
    }

    //初始化jedis连接池对象
    private static void init(){
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数 （长工+临时工）
        config.setMaxTotal(500);
        //最大空闲数 (长工)
        config.setMaxIdle(200);
        //等待可用连接最大时间，超过这个时间仍未获取到jedis实例的话，直接抛JedisConnectionException
        config.setMaxWaitMillis(5000);
        jedisPool = new JedisPool(config, "localhost", 6379, 1000);
    }

    //对外提供获取jedis连接池实例的方法
    public static Jedis getClient(){
        return jedisPool.getResource();
    }

}
