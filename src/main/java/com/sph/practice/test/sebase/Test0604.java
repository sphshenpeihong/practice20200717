package com.sph.practice.test.sebase;

import com.sph.practice.test.jedis.utils.JedisUtils;
import org.junit.Test;

import java.util.*;

/**
 * Created by Shen Peihong on 2020/6/4 17:58
 * Description:
 *
 * @since 1.0.0
 */
public class Test0604 {

    /**
     * 测试Integer是否可以使用equals方法
     */
    @Test
    public void test1(){

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

}
