package com.sph.practice.test.controller.ui;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sph.practice.test.bean.UserParam;
import com.sph.practice.test.jedis.JedisTemplateTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


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

    /**
     * 操作String类型的方法  （opsForValue）
     */
    @RequestMapping("/test4.do")
    public void test4(){
        ValueOperations valueOperations = redisTemplate.opsForValue();//redisTemplate把jedis客户端的5种数据类型使用5个接口分别归类，创建出对应的接口对象，即可操作里面的相关API
        valueOperations.set("username","123");//设置缓存键值对
        System.out.println(valueOperations.get("username"));//获取值
    }

    /**
     * 操作String类型的方法  （opsForValue） 设置简单键值对并设置过期时间
     */
    @RequestMapping("/test5.do")
    public void test5() throws InterruptedException {
        ValueOperations valueOperations = redisTemplate.opsForValue();//redisTemplate把jedis客户端的5种数据类型使用5个接口分别归类，创建出对应的接口对象，即可操作里面的相关API
        valueOperations.set("username","456",10,TimeUnit.MILLISECONDS);//将一个键值对放入缓存并设置过期时间，单位由arg4指定
        System.out.println(redisTemplate.opsForValue().get("username"));//获取值，值未过期，可获取到
        Thread.sleep(11);//当前线程休眠11毫秒
        System.out.println(redisTemplate.opsForValue().get("username"));//再次获取值，缓存值已过期，未能够获取到
    }

    /**
     * 设置键值对(当key不存在时，新增， 若key存在，则不新增)
     */
    @RequestMapping("/test6.do")
    public void test6(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Boolean isAbsent = valueOperations.setIfAbsent("username", "1234");//当该key不存在缓存之中的话，则添加新的键值对，若存在的话，则不更改。返回值为true，则代表该key原先不存在于缓存中，添加新键值对成功
        if (isAbsent){
            System.out.println("添加新的键值对成功");
            System.out.println("打印新添加的键值对，值为：" + redisTemplate.opsForValue().get("username")); //添加成功
            Boolean againIsAbsent = valueOperations.setIfAbsent("username", "66565");
            if (!againIsAbsent){
                System.out.println("添加新的键值对失败"); //key已存在，添加失败
            }
        }
    }

    /**
     * 设置键值对(当key不存在时，新增， 若key存在，则不新增)  并设置过期时间
     */
    @RequestMapping("/test7.do")
    public void test7(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        redisTemplate.delete("username");//对缓存进行删除
        Boolean isAbsent = valueOperations.setIfAbsent("username", "1234",1,TimeUnit.MINUTES);//当该key不存在缓存之中的话，则添加新的键值对，若存在的话，则不更改。返回值为true，则代表该key原先不存在于缓存中，添加新键值对成功
        if (isAbsent){
            System.out.println("添加新的键值对成功");
            System.out.println("打印新添加的键值对，值为：" + redisTemplate.opsForValue().get("username")); //添加成功
            System.out.println("输出该key所对应的过期时间，" + redisTemplate.getExpire("username"));
            System.out.println("输出该key所对应的过期时间，" + redisTemplate.getExpire("username1"));//若获取为-1，则代表该key不存在于缓存中
            Boolean againIsAbsent = valueOperations.setIfAbsent("username", "66565");
            if (!againIsAbsent){
                System.out.println("添加新的键值对失败"); //key已存在，添加失败
            }
        }
    }

    /**
     * 将一个map集合的k-v都放入缓存里
     */
    @RequestMapping("/test8.do")
    public void test8(){
        Map<String, Object> map = Maps.newHashMap();
        map.put("username","123");
        map.put("password","456");
        Map<String, Object> map1 = Maps.newHashMap();
        map.put("username","999");
        redisTemplate.opsForValue().multiSet(map1);//将一个map都放入缓存中(若map中某个key在缓存中已存在，则添加不成功)
        System.out.println(redisTemplate.opsForValue().get("username")); //123
        System.out.println(redisTemplate.opsForValue().get("password")); //456
        System.out.println(redisTemplate.opsForValue().get("sex")); //null
    }

    /**
     * 操作String类型的方法
     */
    @RequestMapping("/test9.do")
    public void test9(){
        Map<String, Object> map = Maps.newHashMap();
        map.put("username","1239");
        map.put("password","456");
        Map<String, Object> map1 = Maps.newHashMap();
        map1.put("username","999");
        map1.put("sex","boy");
        redisTemplate.delete("sex");
        Boolean ifAbsent = redisTemplate.opsForValue().multiSetIfAbsent(map);
        System.out.println(ifAbsent);
        System.out.println(redisTemplate.opsForValue().get("username")); //123
        System.out.println(redisTemplate.opsForValue().get("password")); //456
        System.out.println(redisTemplate.opsForValue().get("sex")); //null
    }

    /**
     * multiGet(Collection<K> keys)
     * 参数是一个列表(keys)，获取一批key所对应的值，返回值也是一个list
     */
    @RequestMapping("/test10.do")
    public void test10(){
        List<String> deleteKeyList = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        redisTemplate.delete(deleteKeyList);
        Map<String, Object> map = Maps.newHashMap();
        map.put("1","1239");
        map.put("2","456");
        map.put("3","boy3");
        map.put("4","boy4");
        map.put("5","boy5");
        map.put("7","boy7");
        map.put("6","boy6");
        map.put("9","boy9");
        map.put("8","boy8");
        map.put("10","boy10");
        List<String> keyList = new ArrayList<>(map.keySet());
        System.out.println(keyList);
        redisTemplate.opsForValue().multiSetIfAbsent(map);
        List<String> valueList = redisTemplate.opsForValue().multiGet(keyList); //入参list(一批keys)，返参是keys所对应的values(按list的顺序传入，返回的下标索引会对应映射)
        System.out.println(valueList); //获取keys所对应的values
    }

    /**
     * 操作String类型的方法
     */
    @RequestMapping("/test11.do")
    public void test11(){
        redisTemplate.opsForValue().set("username", "123");
        redisTemplate.opsForValue().get("username");
        redisTemplate.opsForValue().set("username", "123", 1, TimeUnit.MINUTES);
        redisTemplate.opsForValue().setIfAbsent("username", "123");
        redisTemplate.opsForValue().setIfAbsent("username", "123", 1, TimeUnit.MINUTES);
        Map<String, Object> map = new HashMap<>();
        redisTemplate.opsForValue().multiSetIfAbsent(map);
        List<String> list = new ArrayList<>();
        redisTemplate.opsForValue().multiGet(list);
    }

    /**
     * getAndSet(key, value); 获得缓存的值，并且重新给该key赋值
     */
    @RequestMapping("/test12.do")
    public void test12(){
        redisTemplate.delete("username");
        redisTemplate.opsForValue().setIfAbsent("username", "123");
        String username = redisTemplate.opsForValue().getAndSet("username", "456").toString(); //获得缓存中key所对应的值，并且重新给该key赋新的值
        System.out.println(username);
        System.out.println(redisTemplate.opsForValue().get("username"));
    }

    /**
     * increment(key, double delta); 给某个Key自增(arg2是增量幅度)
     */
    @RequestMapping("/test13.do")
    public void test13(){
        stringRedisTemplate.delete("age");
        stringRedisTemplate.opsForValue().set("age", "0");
        Long age = stringRedisTemplate.opsForValue().increment("age", 2);//返回值是自增后的结果，arg2是自增的增量幅度
        System.out.println(age);
    }

    /**
     * 下面开始是key绑定的
     */
    @RequestMapping("/test14.do")
    public void test14(){
        redisTemplate.delete("username");
        //不再使用opsForValue()，而是使用boundValueOps(key);直接将缓存某一个key绑定起来，并返回绑定对象(类型是BoundValueOperations)
        //BoundValueOperations类提供了许多API接口，自此后，该key绑定对象，可以调用里面的接口操作相关与key相关的操作
        BoundValueOperations username = redisTemplate.boundValueOps("username");//将key为username，绑定起来，返回绑定对象
        username.set("666"); //设置value
        System.out.println(username.get()); //获取value
    }

    /**
     * 绑定完缓存中的某个key后进行自增
     */
    @RequestMapping("/test15.do")
    public void test15(){
        BoundValueOperations num = redisTemplate.boundValueOps("num");//绑定缓存中的某个key
        Long increaseNum = num.increment(1L); //对key的值进行自增
        //想自增的话建议使用这种方式，而不要去使用stringRedisTemplate了
        System.out.println("自增完：" + increaseNum);
    }

    /**
     * 试试绑定某个key后，能不能append()
     */
    @RequestMapping("/test16.do")
    public void test16(){
        BoundValueOperations specialString = redisTemplate.boundValueOps("specialString");
        Integer append = specialString.append("123|");
        System.out.println("看看数字类型返回啥：" + append);
        System.out.println(redisTemplate.opsForValue().get("specialString", 0,append));
        //System.out.println(specialString.get());
    }

    /**
     * 使用append连接起来，然后进行获取
     */
    @RequestMapping("/test17.do")
    public void test17(){
        BoundValueOperations strings = redisTemplate.boundValueOps("strings");
        for (int i = 0; i < 10; i++) {
            //进行拼接缓存key所对应的值
            strings.append(i + "|");
        }
        //打印结果  size()得到字符串的长度
        System.out.println(strings.get(0,strings.size())); //这里size()比平常的字符串多了7 到时候看看怎么回事
    }

    /**
     * 获取缓存中字符串的长度
     */
    @RequestMapping("/test18.do")
    public void test18(){
        redisTemplate.delete("size");
        BoundValueOperations size = redisTemplate.boundValueOps("size");
        size.set("aaabcd");
        System.out.println(size.get().toString().length());
    }

    /**
     *
     */
    @RequestMapping("/test19.do")
    public void test19(){
        BoundValueOperations strings = redisTemplate.boundValueOps("strings1");
        strings.set("123213");
        System.out.println(strings.size());
    }

    //--------分割线----------
    /**
     *
     */
    @RequestMapping("/test20.do")
    public void test20(){
        UserParam userParam = new UserParam();
        userParam.setId("11");
        UserParam userParam1 = new UserParam();
        userParam1.setId("21");
        List<UserParam> list = new ArrayList<>();
        list.add(userParam);
        list.add(userParam1);
        BoundValueOperations test = redisTemplate.boundValueOps("test");
        test.set(JSON.toJSONString(list));
        System.out.println(test.get());
    }

    /**
     *
     */
    @RequestMapping("/test21.do")
    public void test21(){

    }

    /**
     *
     */
    @RequestMapping("/test22.do")
    public void test22(){

    }

    /**
     *
     */
    @RequestMapping("/test23.do")
    public void test23(){

    }


}
