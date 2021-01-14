package com.sph.practice.test.sebase;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sph.practice.test.bean.User;
import com.sph.practice.test.controller.bean.DefaultBean;
import com.sph.practice.test.jedis.utils.JedisUtils;
import com.sph.practice.test.param.BankVO;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/6/4 17:58
 * Description:
 *
 * @since 1.0.0
 */
public class Test0604 {

    public void invokeTest(){
        System.out.println("该方法对外提供调用");
    }

    /**
     *
     */
    @Test
    public void test1(){
        BankVO bankVO = new BankVO();
    }

    /**
     * StringBuffer  append 拼接
     */
    @Test
    public void test2(){
        String test = "123123";
        String preId = "123123121";
        System.out.println(test + "preId=" + preId);
    }

    /**
     * 使用Map提供的几个新的方法
     */
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<>();
        map.put("username",null);
        Integer username11 = map.getOrDefault("username11", 212);
        System.out.println("打印出：+" + username11);
        map.keySet().forEach(k -> System.out.println(k));
        //System.out.println(map.compute);
    }

    /**
     * 试试TreeMap
     */
    @Test
    public void test4(){
        Map<Integer,Object> map = new TreeMap<>();
        map.put(2,2);
        map.put(4,2);
        map.put(5,2);
        map.put(3,2);
        map.put(1,2);
        map.put(9,2);
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((v1, v2) -> v1-v2);
        list.stream().forEach(System.out::println);


    }

    /**
     * 类型强转
     */
    @Test
    public void test5(){
        Map<String,Object> map = new TreeMap<>();
        map.put("ab","1");
        map.put("zg","1");
        map.put("zd","1");
        map.put("ba","3");
        map.put("d","3");
        map.put("za","3");
        map.put("zb","3");
        map.put("c","3");
        map.put("e","3");
        map.put("x","3");
        map.put("f","3");
        map.put("g","2");
        map.keySet().forEach(k -> System.out.println(k));
    }

    /**
     *
     */
    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            JedisUtils.test();
        }
        //静态代码块只会在类加载的时候才会去执行，只执行一次
        System.out.println("1111");
    }

    /**
     * 定义一个泛型方法，参数带泛型的话，那么该方法是泛型方法，则需要记得声明方法是泛型方法
     */
    @Test
    public void test11(){
        List<String> list = Lists.newArrayList("123", "456");
        String[] ss = new String[]{"111","44444"};
        this.serial(ss);
    }

    private <E> void serial(E objects){
        if (objects instanceof List){
            for (String object : (List<String>)objects) {
                System.out.println(object);
            }
        } else if (objects instanceof String[]){
            for (String object : (String[])objects) {
                System.out.println(object);
            }
        }
    }

    @Test
    public void test12(){
        User u = new User(1, "1", "2");
        System.out.println(this.returnObject(u).getUsername());
    }

    //返回指定泛型对象
    private <T> T returnObject(T t){
        return t;
    }

    /**
     * 测试一下TimeUnit枚举类
     */
    @Test
    public void test0(){
        System.out.println(TimeUnit.DAYS.toHours(1));
        System.out.println(TimeUnit.MINUTES);
    }

    @Test
    public void test123(){
        Set<String> set = new HashSet<>();
    }

    private static int num = 0;

    public static void main(String[] args) {
        System.out.println(num);
        num++;
        main(args);
    }

    /**
     *
     */
    @Test
    public void test6(){
        List<String> list = getList();
        list.add("123");
    }

    private List<String> getList(){

        return Collections.emptyList();
    }

    //试试封装查询参数 map
    /**
     *
     */
    @Test
    public void test13(){
        test13a("111","222");
    }

    private void test13a(Object... Object){
        List<String> strings = Lists.newArrayList("111", "222");
        Map<String, Object> map = Maps.newHashMap();
        map.put("username", "123");
        System.out.println(map.get("username"));
        map.put("username", "456");
        System.out.println(map.get("username"));
    }

    //用一下Hutool 任意一个为空则有问题
    /**
     *
     */
    @Test
    public void test7(){
        boolean flag1 = ObjectUtil.isAllNotEmpty(null, null);
        boolean flag2 = ObjectUtil.isAllEmpty("123", null);
        System.out.println("flag1 = " + flag1);
        System.out.println("flag2 = " + flag2);
    }

    /**
     *
     */
    @Test
    public void test8(){
    }

    /**
     *
     */
    @Test
    public void test9(){
        DefaultBean defaultBean = new DefaultBean();
        System.out.println(defaultBean);
    }



}
