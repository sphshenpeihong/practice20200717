package com.sph.practice.test.markdown.redis.jedis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * Created by Shen Peihong on 2020/11/9 21:23
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/jedis")
public class JedisCtl {

    /**
     * 手动创建jedis对象，并且操作String类型数据
     */
    @RequestMapping("/test1.do")
    public void test1() {
        //下面我们将使用我们的Java代码访问redis服务器，需要先跟redis服务器取得连接，才能进一步对redis数据库进行操作
        //步骤和使用JDBC连接mysql数据库一样，需要先建立连接，建立完连接后，对数据库进行操作，最后释放连接
        //后面使用对象池，对连接对象进行管理，默认初始化几百个或几千个连接对象，不用每次都自己去使用构造方法创建连接对象
        //我们利用Jedis生成连接redis数据库的对象，需要知道URL和端口号
        //一般我们会定义一个jedis工具类，里面封装了使用jedis连接池生成jedis对象，提供getClinet方法，以后调用Jedis工具类去获取jedis对象
        Jedis jedis = new Jedis("localhost", 6379);
        //2、对redis数据库进行操作
        jedis.del("username1");
        jedis.set("username", "zhangsan");
        System.out.println(jedis.get("username"));
        jedis.setex("vertifyCode", 60, "675420");//key/value有效时间60秒
        //第一次运行代码的话 下面会打印null，因为还没有入redis库
        System.out.println(jedis.get("password"));
        jedis.set("password", "bugaosuni");
        //3、释放连接
        jedis.close();
    }

    /**
     * 缓存的value值为hashMap类型
     */
    @RequestMapping("/test2.do")
    public void test2() {
        Jedis jedis = new Jedis();
        jedis.hset("hashMap1", "username", "zhangsan");
        jedis.hset("hashMap1", "password", "123456");
        System.out.println(jedis.hget("hashMap1", "username"));
        Map<String, String> hashMap1 = jedis.hgetAll("hashMap1");//已获得redis数据库该key对应的Map类型
        //获得map中的所有key集合
        Set<String> keySet = hashMap1.keySet();
        //获得map中的每一对映射关系
        Set<Map.Entry<String, String>> entrySet = hashMap1.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        jedis.close();
    }

    /**
     * 缓存的value值为ArrayList类型
     */
    @RequestMapping("/test3.do")
    public void test3(){
        Jedis jedis = new Jedis();
        //类似于队列
        jedis.lpush("list1", "a");
        jedis.lpush("list1", "b");
        jedis.rpush("list1", "c");
        System.out.println(jedis.lrange("list1", 0, 2));
        System.out.println(jedis.lpop("list1"));//删除最左边一个元素
        System.out.println(jedis.lrange("list1", 0, -1));
        jedis.close();
    }

    /**
     * 缓存的value值为set类型
     */
    @RequestMapping("/test4.do")
    public void test4(){
        Jedis jedis = new Jedis();
        jedis.sadd("set1", "a");
        jedis.sadd("set1", "b");
        jedis.sadd("set1", "c");
        System.out.println(jedis);
        Set<String> set1 = jedis.smembers("set1");
        System.out.println(set1);
    }

    /**
     * geospatial
     */
    @RequestMapping("/test5.do")
    public void test5(){
        Jedis jedis = JedisClient.getClient();
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

    @RequestMapping("/test12.do")
    public void test12(){

    }

    @RequestMapping("/test13.do")
    public void test13(){

    }
    @RequestMapping("/test14.do")
    public void test14(){

    }
    @RequestMapping("/test15.do")
    public void test15(){

    }

    @RequestMapping("/test16.do")
    public void test16(){

    }

    @RequestMapping("/test17.do")
    public void test17(){

    }





}
