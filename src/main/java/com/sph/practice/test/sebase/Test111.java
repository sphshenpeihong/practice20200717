package com.sph.practice.test.sebase;

import com.google.common.collect.Lists;
import com.sph.practice.test.bean.User;
import com.sph.practice.test.bean.UserParam;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
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

    //这里定义一个final常量 和 String字符串 ，然后分别两个类去使用到它  然后一个地方改变后，其它地方会不会影响到

    /**
     *
     */
    @Test
    public void test10() throws InterruptedException {
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

    /**
     *
     */
    @Test
    public void test7(){
        List<String> list = Lists.newArrayList();
        list.add("123");
        list.add(null);
        System.out.println(list);
        List<String> collect = list.stream().filter(k -> k == null).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 上传
     */
    @Test
    public void test8() throws FileNotFoundException {
        File file = new File("d:\\qycache\\111\\天下无贼-高清480P.qsv");
        if (file.exists()){
            System.out.println("存在");
            System.out.println(file.length());
        }
        System.out.println("bu");
        FileInputStream fis = new FileInputStream(file);
    }

    /**
     * ReentrantLock lockInterruptibly
     */
    @Test
    public void test9(){

    }

    //用于markdown demo详细全方法



    /**
     * Java代码获取某个IP对象
     */
    @Test
    public void test() throws UnknownHostException {
        //也可以根据主机名(计算机名)构建InetAddress对象
        InetAddress ip = InetAddress.getByName("LAPTOP-OSAFAJBF");
        //也可以根据ip地址(字符串)构建InetAddress对象
        InetAddress ip1 = InetAddress.getByName("192.168.11.125");
    }

    /**
     * 这里试试时间计算问题，秒级
     */
    @Test
    public void test12() throws InterruptedException {
        //直接设置一个时间
        LocalDate of = LocalDate.of(2021, 0, 14);
        Date date = new Date();
        //设置一个日期，计算两个日期的前后关系
        Date date1 = new Date();
        boolean before = date.before(date1);
        System.out.println(before);
    }









}
