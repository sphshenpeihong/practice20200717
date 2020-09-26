package com.sph.practice.test.sebase;

import com.google.common.collect.Lists;
import com.sph.practice.test.bean.UserParam;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shen Peihong on 2020/9/17 17:06
 * Description:
 *
 * @since 1.0.0
 */
public class Test111 {

    /**
     *
     */
    @Test
    public void test() throws InterruptedException {
        List<String> list = Lists.newArrayList();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("123123");
                list.add("123123");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        System.out.println(list);
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> list = Lists.newArrayList();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("123123");
                list.add("123123");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        System.out.println(list);
    }

    /**
     * 不简写
     */
    @Test
    public void test1(){
        List<String> list = Lists.newArrayList("111", "222", "333");
        List<String> filter = list.stream().filter(k -> k.equals("111")).collect(Collectors.toList());
        List<String> collect = filter.stream().map(k -> k).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(filter);
    }

    /**
     * 简写
     */
    @Test
    public void test2(){
        List<String> list = Lists.newArrayList("111", "222", "333");
        List<String> filter = (List<String>) list.stream().filter(new Predicate(){
            @Override
            public boolean test(Object o) {
                if (o.toString().equals("111")){
                    return true;
                }
                return false;
            }
        }).collect(Collectors.toList());
        System.out.println(filter);
    }

    /**
     * 半简写
     */
    @Test
    public void test3(){
        List<String> list = Lists.newArrayList("111", "222", "333");
        List<String> filter = (List<String>) list.stream().filter(k -> {
            if (k.equals("111")){
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        System.out.println(filter);
    }

    @Test
    public void test4(){
        String s = "123";
        String[] split = Optional.ofNullable(s).orElse("").split("\\|");
        String connection = Lists.newArrayList(split).stream().collect(Collectors.joining("，"));
        System.out.println(connection);
    }

    //判断一个VO能否进行二次流式处理
    @Test
    public void test5(){
        UserParam u1 = new UserParam();
        u1.setId("1");
        u1.setUsernmae("123");
        UserParam u2 = new UserParam();
        u2.setId("2");
        u2.setUsernmae("456");
        List<UserParam> list = Lists.newArrayList(u1, u2);
        Stream<UserParam> stream = list.stream();
        List<String> collect = list.stream().map(UserParam::getId).collect(Collectors.toList());
        List<String> collect1 = list.stream().map(UserParam::getUsernmae).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect1);
    }

    @Test
    public void test6(){
        Map<String, String> map = new HashMap<>();
        map.put("123","123");
        Object s = 123;
        if (s instanceof String) System.out.println("123");
        System.out.println(map.get(s.toString()));
    }

}
