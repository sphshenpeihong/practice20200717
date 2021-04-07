package com.sph.practice.test.localdata;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Locale;

/**
 * Created by Shen Peihong on 2020/6/17 17:48
 * Description:试试JDK8提供的日期时间工具类
 *
 * LocalData 日期工具类
 * LocalTime 时间工具类
 * LocalDataTime 日期时间工具类
 * @since 1.0.0
 */
public class LocalDataTest {

    private String pattern = "yyyy-MM-dd HH:mm:ss";

    //测试日期工具类LocalDate
    @Test
    public void testLocalDate(){
        //获取当前日期 直接经过格式化的
        LocalDate now = LocalDate.now(); //结果：2020-06-17
        //自己设置的日期
        LocalDate of = LocalDate.of(2020, 6, 17);//结果：2020-06-17
        //获取日期的年
        now.get(ChronoField.YEAR); //获取年份，结果：2020 （推荐使用）
        int month = now.get(ChronoField.MONTH_OF_YEAR); //获取月份，结果：6 （推荐使用）
        int day = now.get(ChronoField.DAY_OF_MONTH);//获取每月中的第几天，结果：17 （推荐使用）
        int i = now.get(ChronoField.DAY_OF_WEEK);//获取星期几，结果：3
    }

    //测试时间工具类LocalTime
    @Test
    public void testLocalTime(){
        LocalTime now = LocalTime.now(); //获取当前时间 结果：18:16:41.525
        LocalTime of = LocalTime.of(18, 16, 01);  //设置时间 结果：18:16:01
        int hour = of.get(ChronoField.HOUR_OF_DAY); //小时  结果：18
        int minute = of.get(ChronoField.MINUTE_OF_HOUR); //分钟 结果：16
        int second = of.get(ChronoField.SECOND_OF_MINUTE); //秒 结果：1
    }

    //测试日期时间工具类LocalDateTime
    @Test
    public void testLocalDateTime(){
        LocalDateTime now = LocalDateTime.now(); //获取当前日期+时间 结果：2020-06-17T18:21:37.098
        LocalDateTime of = LocalDateTime.of(2020, Month.JUNE, 17, 18, 21, 36); //自定义时间带T 需要格式化
        System.out.println(of);
        LocalDate localDate = LocalDate.of(2020, 06, 07);
        LocalTime localTime = LocalTime.of(18, 06, 36);
        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(localDateTime);
    }

    /**
     * 格式化日期时间
     */
    @Test
    public void testDateTimeFormatter(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss",Locale.JAPANESE); //格式化对象
        String format = LocalDateTime.now().format(dtf);//当前时间 进行格式化
        System.out.println(format);
    }

    /**
     * Instant
     */
    @Test
    public void testInstant(){
        long epochSecond = Instant.now().getEpochSecond(); //获得时间戳精确到秒
        long toEpochMilli = Instant.now().toEpochMilli(); //获得时间戳精确到毫秒 等同 System.currentMillis();
        System.out.println(System.currentTimeMillis());


    }

    // String转LocalDateTime
    @Test
    public void stringToLocalDateTime(){
        String str = "2020-04-06 18:40:40";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern,Locale.CHINESE); //格式化对象
        LocalDateTime parse = LocalDateTime.parse(str, dtf);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(parse);
    }

    /**
     *
     */
    @Test
    public void test(){
        System.out.println("莫莫");
    }

    /**
     * LocalData 入参String 和当前的日期做比较
     */
    @Test
    public void test1(){
        String str = "2021-01-16";
        LocalDate parse = LocalDate.parse(str);
        System.out.println(parse.get(ChronoField.MONTH_OF_YEAR));
        LocalDate now = LocalDate.now();
        boolean before = now.isBefore(parse);
        System.out.println(before);
    }

}
