package com.sph.practice.test.markdown.test;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Created by Shen Peihong on 2020/10/20 22:26
 * Description: Date
 *
 * @since 1.0.0
 */
public class DateTest {

    /**
     * new Date();
     */
    @Test
    public void test1(){
        Date date = new Date();
        System.out.println(date);
    }

    /**
     * after(Date)
     */
    @Test
    public void test2(){
        Date now = new Date();
        long currentTimeMillis = System.currentTimeMillis();
        long aMinuteAgo = currentTimeMillis - (60 * 1000);//一分钟前的时间戳
        //当前时间是否在 "一分钟前" 之后？ 答案是：true
        boolean after = now.after(new Date(aMinuteAgo));//若当调用此方法的Date对象在指定日期之后返回true,否则返回false
        System.out.println(after);
        /*
            true
         */
    }

    /**
     * boolean before(Date date) //若当调用此方法的Date对象在指定日期之前返回true,否则返回false
     */
    @Test
    public void test3(){
        Date now = new Date();
        long currentTimeMillis = System.currentTimeMillis();
        long aMinuteAgo = currentTimeMillis - (60 * 1000);//一分钟前的时间戳
        //当前时间是否在 "一分钟前" 前？ 答案是：false
        boolean before = now.before(new Date(aMinuteAgo));//若当调用此方法的Date对象在指定日期之后返回true,否则返回false
        System.out.println(before);
        /*
            false
         */
    }

    /**
     * int compareTo(Date date) //比较当调用此方法的Date对象和指定日期 两者相等时候返回0 调用对象在指定日期之前则返回负数 调用对象在指定日期之后则返回正数
     */
    @Test
    public void test4(){
        Date now = new Date();
        long currentTimeMillis = System.currentTimeMillis();
        long aMinuteAgo = currentTimeMillis - (60 * 1000);//一分钟前的时间戳
        //比较当调用此方法的Date对象和指定日期两者相等时候返回0 调用对象在指定日期之前则返回负数 调用对象在指定日期之后则返回正数
        int compare = now.compareTo(new Date(aMinuteAgo));
        System.out.println(compare);
        /*
            1
         */
    }

    /**
     * Date转Long
     */
    @Test
    public void test5(){
        Date date = new Date();
        long l = date.toInstant().toEpochMilli();
        System.out.println(l);
        System.out.println(System.currentTimeMillis());
    }

    /**
     * LocalDatetime换时间戳
     */
    @Test
    public void test6(){
        // 精确到秒
        /*LocalDateTime now = LocalDateTime.now();
        long l = now.toEpochSecond(ZoneOffset.MIN);
        long l1 = now.toEpochSecond(ZoneOffset.UTC);
        long l2 = now.toEpochSecond(ZoneOffset.MAX);
        now.toEpochSecond(ZoneOffset.)
        System.out.println(l);
        System.out.println(l1);
        System.out.println(l2);*/
    }

    /**
     *
     */
    @Test
    public void test7(){
        // LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);


        // Date
        Date date = new Date();
        System.out.println(date);


    }


}