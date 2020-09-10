package com.sph.practice.test.jedis.utils;

/**
 * Created by Shen Peihong on 2020/9/10 14:29
 * Description:初始化Jedis连接池
 *
 * @since 1.0.0
 */
public class JedisClient {

    //一、暂时写死，定义Jedis连接池
    //Redis服务器IP
    private static String HOST = "127.0.0.1";

    //Redis的端口号
    private static Integer PORT = 6379;

    //访问密码
    private String AUTH = "root";

    //二、init方法，初始化Jedis连接池
}
