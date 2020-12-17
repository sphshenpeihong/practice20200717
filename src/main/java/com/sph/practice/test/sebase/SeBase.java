package com.sph.practice.test.sebase;

import com.google.common.collect.Maps;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by Shen Peihong on 2020/5/31 0:27
 * Description:
 *
 * @since 1.0.0
 */
public class SeBase {

    private final static Logger logger = LoggerFactory.getLogger(SeBase.class);

    /**
     * 学习Calendar日历类
     */
    @Test
    public void test1(){
        //获取Calendar实例，构造方法不可用 提供了静态方法getInstance()
        //初始化日历类实例里面封装了很多成员变量，提供了许多和时间相关的信息
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();//获得当前时间 Date类型
        //月份是从0开始的  周日是1
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //在该月的第几号
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));  //在该年的第几天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));  //在本周的第几天 (下标从周日开始)

    }

    @Test
    public void test2(){
        Calendar calendar = Calendar.getInstance();//得到一个日历对象 里面封装许多信息，可以通过getTime()获得时间戳，从而转成Date对象
        //一般只需要用到时间的话，那么使用new Date()创建时间对象即可，但是需要计算一些复杂一点的日历相关信息的话，那么久用日历对象
        System.out.println(calendar);
        long dayTime = 1000*60*60*24; //一天的毫秒数
        System.out.println(new Date());
        //昨天的现在
        //Date是日期类 利用它可以解决时间相关的信息
        Date date = new Date(new Date().getTime() - dayTime);
        System.out.println(date);
        //Calendar是日历类，给定它一个时间， 可以输出是星期几，第几周，年中的第几天，该月总共有多少天等相关信息

    }

    @Test
    public void test3(){
        long dayTime = 1000*60*60*24; //一天的毫秒数
        Calendar calendar = Calendar.getInstance();
        Date yesterday = new Date(new Date().getTime() - dayTime);
        System.out.println(yesterday.getTime());
        calendar.setTime(yesterday); //给日历对象设置一个时间
        System.out.println(calendar.getTime().getTime());
    }

    /**
     *
     */
    @Test
    public void test31(){
        //里面可以获取到很多成员变量的信息 底层和OS对接的。
        Calendar calendar = Calendar.getInstance();
        //arg1：时间单位
        //arg2：偏移量
        calendar.add(Calendar.SECOND, 60);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(calendar.getTime());
        System.out.println(str);

    }

    /**
     *
     */
    @Test
    public void test32(){
        Calendar instance = Calendar.getInstance();
        long dayTime = 1000*60*60*24; //一天的毫秒数
        long l = new Date().getTime() - dayTime;
        Date date = new Date(l);
        instance.setTime(date);
        System.out.println(date);
        System.out.println(instance);
        //date值setTime到Calendar对象中

        //add 给日期类增加日期
        //setTime是直接设置一个值 更改时间
        //add方法可以增加偏移量 给Calendar对象
        //getTime是直接获取获取直接戳对应的时间了。new Date(时间戳)


    }

    @Test
    public void test4(){
        Calendar calendar = Calendar.getInstance();
        Object clone = calendar.clone();
        System.out.println(calendar.equals(clone));
    }

    /**
     * LocalTime
     */
    @Test
    public void test5(){
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }

    //先试试map 获取键值对后 判断后修改
    /**
     *
     */
    @Test
    public void test6(){
        //按你放进去的顺序 而不是根据key去排序
        Map<Integer, Object> map = new LinkedHashMap<Integer, Object>() {{
            put(1,"123");
            put(0,"456");
        }};
        map.values().stream().forEach(k -> System.out.println(k));
    }

    /**
     *
     */
    @Test
    public void test7(){
        OrdinaryThread thread = new OrdinaryThread();
        thread.start();
    }

    /**
     *
     */
    @Test
    public void test8(){
        Integer i1 = 1;
        Integer i2 = 1;
        int i3 = 1;
        int i4 = 1;
        logger.info("1231231打印");
    }

    private String getName(){
        System.out.println("123");
        System.out.println("456");
        return "123";
    }


}
