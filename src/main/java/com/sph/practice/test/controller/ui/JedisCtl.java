package com.sph.practice.test.controller.ui;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sph.practice.test.bean.UserParam;
import com.sph.practice.test.jedis.JedisTemplateTest;
import com.sph.practice.test.param.BankVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.*;
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

    /* ********      String start       **************/
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

    /**
     * 测试缓存存json字符串
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
    /* ********      String end       **************/

    /* ********      List start       **************/
    /**
     * opsForList() boundListOps(key) 两种方式新建对象
     * 初始化一批数据
     */
    @RequestMapping("/test21.do")
    public void test21(){
        ListOperations listOperations = redisTemplate.opsForList();//创建list缓存对象，操作缓存list类型的相关接口
        BoundListOperations key1 = redisTemplate.boundListOps("list1"); //创建list类型的绑定key对象
        key1.leftPushAll("123","456","789");

    }

    /**
     * 简单各种方式存值、各种方式获取值、设置过期时间
     */
    @RequestMapping("/test22.do")
    public void test22(){
        ListOperations listOperations = redisTemplate.opsForList();//创建list缓存对象
        //listOperations.leftPush("list1", "999"); //从左边插入值
        listOperations.leftPush("list1", "666", "999");//从左边插入值，并插在值666的前面，若key为list1的List中没有666这个值，则插入不成功
        //listOperations.leftPush("list1","456");
        System.out.println(listOperations.range("list1", 0, -1));
    }

    /**
     * 从右边插入值
     */
    @RequestMapping("/test23.do")
    public void test23(){
        ListOperations listOperations = redisTemplate.opsForList();//创建list缓存对象
        listOperations.rightPush("list1", "777");
        List list1 = listOperations.range("list1", 0, -1);//获得list的列表，位置从0到-1，结束位置若为-1，则获取该key对应的list全部元素
        System.out.println(list1);
    }

    /**
     * 从右边方向插入值（指定值）
     */
    @RequestMapping("/test24.do")
    public void test24(){
        ListOperations listOperations = redisTemplate.opsForList();//创建list缓存对象
        listOperations.rightPush("list1", "456", "258");
        List list1 = listOperations.range("list1", 0, -1);//获得list的列表，位置从0到-1，结束位置若为-1，则获取该key对应的list全部元素
        System.out.println(list1);
    }

    /**
     * 获取key所对应的整个list列表 arg1:缓存key arg2：起始位置  arg3：结束位置
     */
    @RequestMapping("/test25.do")
    public void test25(){
        ListOperations listOperations = redisTemplate.opsForList();//创建list缓存对象
        List list2 = listOperations.range("list2", 0, 5);//获得list的列表，位置从0到-1，结束位置若为-1，则获取该key对应的list全部元素
        Long size = listOperations.size("list2"); //整个list的长度
        System.out.println(list2);
        System.out.println(listOperations.size("list2"));
        System.out.println(list2.size());
    }

    /**
     *
     */
    @RequestMapping("/test26.do")
    public void test26(){
        ListOperations listOperations = redisTemplate.opsForList();
        List<String> list = Lists.newArrayList("1", "3", "2", "4", "7", "5", "6");
        System.out.println(list);
        listOperations.leftPushAll("list2", list); //左插，会按list的顺序进行顺序插入
    }

    /**
     * 测试一批list("有序")数据，放到有序map LinkedHashMap put进去的值都是按顺序存储的
     */
    @RequestMapping("/test27.do")
    public void test27(){
        List<String> list = Lists.newArrayList("1", "3", "2", "4", "7", "5", "6");
        Map<String, Object> map = Maps.newLinkedHashMap();
        map.put("1","1");
        map.put("3","3");
        map.put("2","2");
        map.put("4","4");
        map.put("7","7");
        map.put("5","5");
        map.put("6","6");
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }

    /**
     * 保留list中指定范围的数，其它的都清除
     */
    @RequestMapping("/test28.do")
    public void test28(){
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.trim("list2", 1, 3); //保留List中指定范围的数，其余的都清除掉
        System.out.println(listOperations.range("list2", 0, -1));
    }

    /**
     * 仅当list存在的话，才会去插入值
     */
    @RequestMapping("/test29.do")
    public void test29(){
        ListOperations listOperations = redisTemplate.opsForList();
        Long list2 = listOperations.leftPushIfPresent("list2", "20");
        System.out.println(list2);
    }

    /**
     * 向集合中指定索引下添加一个新元素，并覆盖当前集合中指定位置的值
     */
    @RequestMapping("/test30.do")
    public void test30(){
        ListOperations listOperations = redisTemplate.opsForList();
        //listOperations.set("list2", 1, "0");
        System.out.println(listOperations.range("list2", 0, -1));
    }

    /**
     * remove
     */
    @RequestMapping("/test31.do")
    public void test31(){
        ListOperations listOperations = redisTemplate.opsForList();
        System.out.println(listOperations.range("list2",0,-1));
        listOperations.remove("list2",2,"666"); //删除list2中值为6的值，删除2个
        System.out.println(listOperations.range("list2",0,-1));
    }

    /**
     *
     */
    @RequestMapping("/test32.do")
    public void test32(){
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPushAll("list2", "666", "666", "66", "666", "6", "666");
        System.out.println(listOperations.range("list2", 0, -1));
    }

    /**
     * 根据索引取list中的值
     */
    @RequestMapping("/test33.do")
    public void test33(){
        Object value = redisTemplate.opsForList().index("list2", 2);  //根据索引取值
        System.out.println(value);
    }

    /**
     * 从list的左边弹出第一个元素，返回值就是左边第一个元素
     */
    @RequestMapping("/test34.do")
    public void test34(){
        redisTemplate.opsForList().leftPushAll("list2","1","2","3");
        System.out.println(redisTemplate.opsForList().range("list2", 0, -1));
        Object value = redisTemplate.opsForList().leftPop("list2");
        System.out.println(value.toString());
        System.out.println(redisTemplate.opsForList().range("list2", 0, -1));
    }

    /**
     *
     */
    @RequestMapping("/test35.do")
    public void test35(){
        System.out.println(redisTemplate.opsForList().range("list2",0,-1));
        redisTemplate.opsForList().rightPopAndLeftPush("list2","list3"); //从list2右边弹出一个，然后把弹出来的这个加到list3的左边
        System.out.println(redisTemplate.opsForList().range("list2",0,-1));
        System.out.println(redisTemplate.opsForList().range("list3",0,-1));

    }

    /*  ***************** list end **********************/

    /*  ***************** hashMap start **********************/

    /**
     * 单个存值与取值
     */
    @RequestMapping("/test36.do")
    public void test36(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("hash","username","123");
        hashOperations.put("hash","password","456");
        System.out.println(hashOperations.get("hash","username"));
    }

    /**
     * 整个map存值与取整个map的值  并且给hashMap设置过期时间
     */
    @RequestMapping("/test37.do")
    public void test37() throws InterruptedException {
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("username","123");
            put("sex","666");
        }};
        hashOperations.putAll("hash1", map);//整个map存值
        System.out.println(hashOperations.get("hash1","username"));
        System.out.println(hashOperations.get("hash1","password"));
        System.out.println(hashOperations.get("hash1","sex"));
        redisTemplate.expire("hash1", 1, TimeUnit.MILLISECONDS);
        Thread.sleep(11);
        System.out.println(hashOperations.get("hash1","username"));
        System.out.println(hashOperations.get("hash1","password"));
        System.out.println(hashOperations.get("hash1","sex"));
    }

    /**
     * 删除hashMap中的某个key-Value
     */
    @RequestMapping("/test38.do")
    public void test38(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("username","123");
            put("sex","666");
        }};
        hashOperations.putAll("hash1", map);//整个map存值
        System.out.println(hashOperations.get("hash1", "username"));
        hashOperations.delete("hash1", "username"); //删除hashMap中的某个k-v键值对
        System.out.println(hashOperations.get("hash1", "username"));
    }

    /**
     * 判断某个hashMap中的某个key是否存在
     */
    @RequestMapping("/test39.do")
    public void test39(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("username","123");
            put("sex","666");
        }};
        hashOperations.putAll("hash1", map);//整个map存值
        System.out.println(hashOperations.hasKey("hash1", "username")); //判断某个map中的某个key是否存在
        System.out.println(hashOperations.hasKey("hash1", "password"));
    }

    /**
     * 给map中的一批Key，查出对应的值
     */
    @RequestMapping("/test40.do")
    public void test40(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new LinkedHashMap<String, Object>() {{
            put("username","123");
            put("password","999");
            put("sex","666");
        }};
        hashOperations.putAll("hash1", map);//整个map存值
        List hash1 = hashOperations.multiGet("hash1", map.keySet()); //给定map中的一批Keys，查出所对应的值
        System.out.println(hash1);
    }

    /**
     * 对map中的某个key执行自增
     */
    @RequestMapping("/test41.do")
    public void test41(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new LinkedHashMap<String, Object>() {{
            put("username",1);
            put("password",1);
            put("sex",1);
        }};
        hashOperations.putAll("hash1", map);//整个map存值
        Long increment = hashOperations.increment("hash1", "sex", 1);
        System.out.println("执行自增后的数字为：" + increment);
        System.out.println();
    }

    /**
     * 411
     */
    @RequestMapping("/test411.do")
    public void test411(){
        BankVO bankVO = new BankVO();
        bankVO.setPersonName("123");
        redisTemplate.opsForList().leftPush("bankVO", bankVO);
        //redisTemplate.opsForValue().set("bankVO", bankVO);
        //System.out.println(redisTemplate.opsForValue().get("bankVO"));
        System.out.println(redisTemplate.opsForList().range("bankVO", 0, -1));
    }

    /**
     * 获取某个map中的所有keys
     */
    @RequestMapping("/test42.do")
    public void test42(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new LinkedHashMap<String, Object>() {{
            put("username",1);
            put("password",1);
            put("sex",1);
        }};
        hashOperations.putAll("hash1", map);//整个map存值
        Set keys = hashOperations.keys("hash1");//获取某个map中的所有Key
        System.out.println(keys);
    }

    /**
     * 获取某个map中的所有values
     */
    @RequestMapping("/test43.do")
    public void test43(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new LinkedHashMap<String, Object>() {{
            put("username",1);
            put("password",2);
            put("sex",3);
        }};
        hashOperations.putAll("hash1", map);//整个map存值
        List values = hashOperations.values("hash1"); //获取某个map中的所有value
        System.out.println(values);
    }

    /**
     * 获取某个map中的所有键值对
     */
    @RequestMapping("/test44.do")
    public void test44(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new LinkedHashMap<String, Object>() {{
            put("username", 1);
            put("password", 2);
            put("sex", 3);
        }};
        hashOperations.putAll("hash1", map);//整个map存值
        Map hash1 = hashOperations.entries("hash1"); //获取某个map中的所有键值对
        for (Object o : hash1.keySet()) {
            System.out.println("key为：" + o.toString() + " 所对应的值为：" + hash1.get(o.toString()));
        }
    }

    /*  ***************** hashMap end **********************/

    /*  ***************** Set start **********************/

    @RequestMapping("/test451.do")
    public void test451(){
        SetOperations setOperations = redisTemplate.opsForSet();
        Set<String> set = new HashSet<>();
        set.add("111");
        set.add("222");
        Set<String> set1 = new HashSet<>();
        set.add("333");
        set.add("444");
        setOperations.add("set1", set, set1);
        //获取
        Set members = setOperations.members("set1");
        System.out.println(members);
    }

    /**
     * 往Set集合中批量add数据 并且获取整个key对应的Set集合
     */
    @RequestMapping("/test45.do")
    public void test45(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi","wangwu"); //批量往某个key 插入元素
        Set set1 = setOperations.members("set1"); //获取某个key对应的所有元素
        System.out.println(set1);
    }

    /**
     * 删除指定key中的某个元素
     */
    @RequestMapping("/test46.do")
    public void test46(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi","wangwu"); //批量往某个key 插入元素
        Long remove = setOperations.remove("set1", "zhangsan","wangwu");//支持删除指定key对应set中的一个元素或多个元素，返回值是删除成功的个数
        System.out.println(remove);
    }

    /**
     * 随机从集合中弹出一个元素，并返回被弹出的值
     */
    @RequestMapping("/test47.do")
    public void test47(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi","wangwu"); //批量往某个key 插入元素
        Object value = setOperations.pop("set1"); //随机地从集合中弹出某一个元素，返回值就是这个被弹出的值
        System.out.println("被弹出的值为：" + value.toString());
        System.out.println(setOperations.members("set1"));
    }

    /**
     * 随机地从集合中弹出指定个数的元素，返回值就是被弹出的list
     */
    @RequestMapping("/test48.do")
    public void test48(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi","wangwu","zhaoliu","shenqi"); //批量往某个key 插入元素
        List popList = setOperations.pop("set1", 2);//随机地从集合中弹出指定个数的元素，返回值就是被弹出的list
        System.out.println(popList);
        System.out.println(setOperations.members("set1"));
    }

    /**
     * 计算出set集合的长度大小
     */
    @RequestMapping("/test49.do")
    public void test49(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi","wangwu","zhaoliu","shenqi"); //批量往某个key 插入元素
        Long size = setOperations.size("set1"); //获得该key对应的set集合的长度大小
        System.out.println("大小为：" + size);
    }

    /**
     * 判断某个set集合中是否存在某个值
     */
    @RequestMapping("/test50.do")
    public void test50(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi","wangwu","zhaoliu","shenqi"); //批量往某个key 插入元素
        Boolean isExist = setOperations.isMember("set1", "zhangsan");//判断某个set集合中是否存在某个成员
        System.out.println(isExist);
    }

    /**
     * 两个key所对应的set集合求交集，并返回求完交集的结果
     */
    @RequestMapping("/test51.do")
    public void test51(){
        redisTemplate.delete("set1");
        redisTemplate.delete("set2");
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi"); //批量往某个key 插入元素
        setOperations.add("set2","lisi","wangwu"); //批量往某个key 插入元素
        Set intersect = setOperations.intersect("set1", "set2"); //两个Key所对应的set进行求交集，返回值是求完交集的结果
        System.out.println(intersect);
    }

    /**
     * 多个Key所对应的set集合求交集，并返回求完交集后的结果
     */
    @RequestMapping("/test52.do")
    public void test52(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi"); //批量往某个key 插入元素
        setOperations.add("set2","lisi","wangwu"); //批量往某个key 插入元素
        setOperations.add("set3","zhaoliu","wangwu"); //批量往某个key 插入元素
        Set intersect = setOperations.intersect(Lists.newArrayList("set1", "set2", "set3")); //多个key所对应的set集合求交集，并返回求完交集后的结果
        System.out.println(intersect);
    }

    /**
     * 两个key所对应的集合求完交集后，将结果集放入第三个集合中
     */
    @RequestMapping("/test53.do")
    public void test53(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi"); //批量往某个key 插入元素
        setOperations.add("set2","lisi","wangwu"); //批量往某个key 插入元素
        setOperations.intersectAndStore("set1","set2","set3"); //两个Key所对应的集合求完交集后，将求完的结果集放入第三个集合中
        Set set3 = setOperations.members("set3");
        System.out.println(set3);
    }

    /**
     * 两个集合求并集，返回值是求完后的结果
     */
    @RequestMapping("/test54.do")
    public void test54(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi"); //批量往某个key 插入元素
        setOperations.add("set2","lisi","wangwu"); //批量往某个key 插入元素
        Set union = setOperations.union("set1", "set2");//两个集合求完交集后，返回值是求完后的结果
        System.out.println(union);
    }

    /**
     * 求补集
     */
    @RequestMapping("/test55.do")
    public void test55(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi"); //批量往某个key 插入元素
        setOperations.add("set2","lisi","wangwu"); //批量往某个key 插入元素
        Set difference = setOperations.difference("set1", "set2"); //求补集，set1有，但set2没有
        System.out.println(difference);
    }

    /**
     * 随机获取集合中的一个元素
     */
    @RequestMapping("/test56.do")
    public void test56(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi", "wangwu", "zhaoliu"); //批量往某个key 插入元素
        Object randomElement = setOperations.randomMember("set1"); //随机获取集合中的一个元素(不是弹出，不会删除该值的)
        System.out.println(randomElement.toString());
        System.out.println(setOperations.members("set1"));
    }

    /**
     * 随机获取集合中的多个元素（可能获取到重复元素）
     */
    @RequestMapping("/test57.do")
    public void test57(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi", "wangwu", "zhaoliu"); //批量往某个key 插入元素
        List randomMembers = setOperations.randomMembers("set1", 2); //随机获取集合中的多个元素（可能获取到了重复元素，比如两个"zhangsan"）
        System.out.println(randomMembers);
    }

    /**
     * 随机获取集合中的多个元素（不重复，不会获取到相同元素的）
     */
    @RequestMapping("/test58.do")
    public void test58(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("set1","zhangsan","lisi", "wangwu", "zhaoliu"); //批量往某个key 插入元素
        Set distinctRandomMembers = setOperations.distinctRandomMembers("set1", 2); //随机获取到集合中的多个元素(不重复，不会获取到相同元素的)
        System.out.println(distinctRandomMembers);
    }

    /**
     * 将一个po对象添加到set中，如果redisTemplate无经过json序列化的话，那么会报错，在配置类直接初始化的时候进行序列化，所以可以使用
     */
    @RequestMapping("/test59.do")
    public void test59(){
        SetOperations setOperations = redisTemplate.opsForSet();
        UserParam userParam = new UserParam();
        userParam.setId("1");
        setOperations.add("set1",userParam); //批量往某个key 插入元素
        Set<UserParam> set1 = setOperations.members("set1");
        for (UserParam param : set1) {
            System.out.println(param.getId());
        }
    }

    /**
     * 将一个po对象添加到list中，如果redisTemplate无经过json序列化的话，那么会报错，在配置类直接初始化的时候进行序列化，所以可以使用
     */
    @RequestMapping("/test60.do")
    public void test60(){
        SetOperations listOperations = redisTemplate.opsForSet();
        UserParam userParam = new UserParam();
        userParam.setId("1");
        List<UserParam> list = new ArrayList<>();
        list.add(userParam);
        listOperations.add("list1", userParam);
        Set<UserParam> set = listOperations.members("list1");
        for (UserParam param : set) {
            System.out.println(param.getId());
        }
    }

    /*  ***************** Set end **********************/
    /*  ***************** ZSet start **********************/

    /**
     * 向set集合中插入元素，并设置分数 ， 并且获取
     */
    @RequestMapping("/test61.do")
    public void test61(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zset1", "zhangsan", 60); //向set集合中插入元素值，并且设置分数
        Set zset1 = zSetOperations.range("zset1", 0, -1);
        System.out.println(zset1);
    }

    /**
     * 删除某个集合中的某个元素 remove
     */
    @RequestMapping("/test62.do")
    public void test62(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        System.out.println(zSetOperations.range("zset1", 0, -1));
        zSetOperations.remove("zset1", "zhangsan"); //删除某个集合中的某个元素值(支持单个或批量删除)
        System.out.println(zSetOperations.range("zset1", 0, -1));
    }

    /**
     * 给某个集合的某个值加分
     */
    @RequestMapping("/test63.do")
    public void test63(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        System.out.println(zSetOperations.range("zset1", 0, -1));
        Double score = zSetOperations.score("zset1", "zhangsan");//返回某个集合的某个元素的分数
        System.out.println(score);
        zSetOperations.incrementScore("zset1", "zhangsan", 2); //给某个集合的某个值加分 （若集合中无此元素值的话，也会去add出来并加分的）
        System.out.println(zSetOperations.score("zset1","zhangsan"));
    }

    /**
     * 初始化一批数据
     */
    @RequestMapping("/test64.do")
    public void test64(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        //输入删除前的数据
        System.out.println(zSetOperations.range("zset1",0,-1));
        //删除数据
        zSetOperations.remove("zset1",Lists.newArrayList("zhangsan","lisi","wangwu"));
        DefaultTypedTuple<String> zhangsan = new DefaultTypedTuple<String>("zhangsan", 60D); //初始化值
        DefaultTypedTuple<String> lisi = new DefaultTypedTuple<String>("lisi", 55D); //初始化值
        DefaultTypedTuple<String> wangwu = new DefaultTypedTuple<String>("wangwu", 55D); //初始化值
        HashSet<DefaultTypedTuple<String>> set = Sets.newHashSet(zhangsan, lisi, wangwu);
        zSetOperations.add("zset1",set);//批量新增集合的元素
        Set range = zSetOperations.range("zset1", 0, -1); //返回集合中所有value元素值，按排名排序(从小到大，小的排在前)
        System.out.println(range);
    }

    /**
     * 给定集合与集合的元素值，求出所在排名 (排名排序从小到大，小的在前)
     */
    @RequestMapping("/test65.do")
    public void test65(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Set range = zSetOperations.range("zset1", 0, -1);
        System.out.println(range);//打印目前缓存的集合
        Long rank = zSetOperations.rank("zset1", "lisi");//返回集合为set1中的lisi的排名 (排名从0开始算)
        System.out.println(rank);//第二名，lisi的分数最大，但是rank的排序是分数小的排在前
    }

    /**
     * 给定集合与集合的元素值，求出所在排名 (排名排序从大到小，大的在前)
     */
    @RequestMapping("/test66.do")
    public void test66(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Long rank = zSetOperations.reverseRank("zset1", "wangwu");//wangwu=55D 最大排前，所以wangwu 返回排名=2
        System.out.println(rank);
    }

    /**
     * 返回集合中的元素的 元素值+排名+分数 （排序按从小到大）
     */
    @RequestMapping("/test67.do")
    public void test67(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> set = zSetOperations.rangeWithScores("zset1", 0, -1);//返回集合中的元素值以及对应的分数 （排序按从小到大）
        int i = 1;
        for (ZSetOperations.TypedTuple<String> tuple : set) {
            System.out.println("值为：" + tuple.getValue() + "，对应的分数为：" + tuple.getScore() + "，当前排名为：" + i++);
        }
    }

    /**
     * //返回集合中的元素值以及对应的分数 （排序按从大到小）
     */
    @RequestMapping("/test68.do")
    public void test68(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> set = zSetOperations.reverseRangeWithScores("zset1", 0, -1);//返回集合中的元素值以及对应的分数 （排序按从大到小）
        int i = 1;
        for (ZSetOperations.TypedTuple<String> tuple : set) {
            System.out.println("值为：" + tuple.getValue() + "，对应的分数为：" + tuple.getScore() + "，当前排名为：" + i++);
        }
    }

    /**
     * 返回集合内元素在指定分数范围内的元素值
     */
    @RequestMapping("/test69.do")
    public void test69(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Set set = zSetOperations.rangeByScore("zset1", 54D, 61D); //返回集合内元素在指定分数范围内的元素值
        System.out.println(set);
    }

    /**
     * 返回集合内元素在指定分数范围内的元素值 并且指定只要从第几个到第几个
     */
    @RequestMapping("/test70.do")
    public void test70(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Set set = zSetOperations.rangeByScore("zset1", 54D, 80D,1,2); //返回集合内元素在指定分数范围内的元素值,并且只取第2个到第3个
        System.out.println(set);
    }

    /**
     * 返回集合内指定分数范围的成员个数
     */
    @RequestMapping("/test71.do")
    public void test71(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Long count = zSetOperations.count("zset1", 55D, 61D); //返回集合内分数在[55,61]的成员个数
        System.out.println(count);
    }

    /**
     * 返回集合内的成员个数
     */
    @RequestMapping("/test72.do")
    public void test72(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Long size = zSetOperations.size("zset1"); //计算集合zset1中的成员个数
        System.out.println(size);
    }

    /**
     * 删除指定索引范围的元素 (排序从小到大)
     */
    @RequestMapping("/test73.do")
    public void test73(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Long removeSize = zSetOperations.removeRange("zset1", 0, 1); //删除索引下标0和1的元素 返回值是删除个数
        System.out.println(removeSize);

    }

    /**
     *
     */
    @RequestMapping("/test74.do")
    public void test74(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Set range = zSetOperations.range("zset1", 0, -1); //删除
        System.out.println(range);
    }

    /**
     * 删除指定分数范围内的元素
     */
    @RequestMapping("/test75.do")
    public void test75(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        Long removeSize = zSetOperations.removeRangeByScore("zset1", 55D, 61D);//删除分数在[55,61]之间的所有元素
        System.out.println(removeSize);
    }

    /**
     *
     */
    @RequestMapping("/test76.do")
    public void test76(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

    }

    /**
     *
     */
    @RequestMapping("/test77.do")
    public void test77(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

    }

    /**
     *
     */
    @RequestMapping("/test78.do")
    public void test78(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

    }

    /**
     *
     */
    @RequestMapping("/test79.do")
    public void test79(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

    }

    /**
     *
     */
    @RequestMapping("/test80.do")
    public void test80(){
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

    }




















}
