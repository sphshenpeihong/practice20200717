package com.sph.practice.test.markdown.test;

import com.sph.practice.test.param.BankVO;
import com.sph.practice.test.param.DateVO;
import com.sph.practice.test.param.TeacherVO;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Shen Peihong on 2020/10/21 14:49
 * Description:
 * LocalDate日期
 * LocalTime 时间
 * LocalDateTime 日期 + 时间
 *
 * @since 1.0.0
 */
public class LocalDateTimeTest {

    /**
     * LocalDate(日期类)
     */
    @Test
    public void test1(){
        //获取当前日期 直接经过格式化的
        LocalDate now = LocalDate.now(); //结果：2020-06-17
        //自己设置的日期
        LocalDate of = LocalDate.of(2020, 6, 17);//结果：2020-06-17
        //获取日期的年
        int year = now.get(ChronoField.YEAR);//获取年份，结果：2020 （推荐使用）
        int month = now.get(ChronoField.MONTH_OF_YEAR); //获取月份，结果：6 （推荐使用）
        int day = now.get(ChronoField.DAY_OF_MONTH);//获取每月中的第几天，结果：17 （推荐使用）
        int i = now.get(ChronoField.DAY_OF_WEEK);//获取星期几，结果：3
        System.out.println("年份：" + year);
        System.out.println("月份：" + month);
        System.out.println("第：" + day + " 号");
        System.out.println("星期" + i);
        /*
            年份：2020
            月份：10
            第：21 号
            星期3
         */
    }

    /**
     * 2.LocalTime 时间类
     */
    @Test
    public void test2(){
        LocalTime now = LocalTime.now(); //获取当前时间 结果：18:16:41.525
        LocalTime of = LocalTime.of(18, 16, 01); //设置时间 结果：18:16:01
        int hour = of.get(ChronoField.HOUR_OF_DAY); //小时 结果：18
        int minute = of.get(ChronoField.MINUTE_OF_HOUR); //分钟 结果：16
        int second = of.get(ChronoField.SECOND_OF_MINUTE); //秒 结果：1
        System.out.println("当前时间为：" + now);
        System.out.println("小时：" + hour);
        System.out.println("分钟：" + minute);
        System.out.println("秒：" + second);
        /*
            当前时间为：19:59:37.146
            小时：18
            分钟：16
            秒：1
         */
    }

    /**
     * LocalDateTime日期时间类  +  DateTimeFormatter格式化日期时间类
     */
    @Test
    public void test3(){
        LocalDateTime now = LocalDateTime.now(); //获取当前日期+时间 结果：2020-06-17T18:21:37.098
        LocalDateTime of = LocalDateTime.of(2020, Month.JUNE, 17, 18, 21, 36); //自定义时间带T 需要格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINESE); //格式化对象
        // String format = LocalDateTime.now().format(dtf);//当前时间 进行格式化  //这个不是24小时制的，要具体后面看（备注）
        String format = of.format(dtf);//当前时间 进行格式化  //这个不是24小时制的，要具体后面看（备注）
        System.out.println(format);
    }

    /**
     *
     */
    @Test
    public void test4(){
        long epochSecond = Instant.now().getEpochSecond(); //获得时间戳精确到秒
        long toEpochMilli = Instant.now().toEpochMilli(); //获得时间戳精确到毫秒 等同 System.currentMillis();
        System.out.println(epochSecond);
        System.out.println(toEpochMilli);
    }

    /**
     *
     */
    @Test
    public void test5(){

    }

    /**
     *
     */
    @Test
    public void test6(){

    }

    /**
     *
     */
    @Test
    public void test7(){

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

    }

    /**
     *
     */
    @Test
    public void test10(){

    }

}
