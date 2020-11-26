package com.sph.practice.test.controller.redis;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Shen Peihong on 2020/11/26 11:21
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/redis/mgr")
public class RedisTemplateMgrCtl {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/test1.do")
    public void test1(){
        GeoOperations geoOperations = redisTemplate.opsForGeo();
        /*
            geoadd：添加经纬度 + 位置
            geodist：给定两个位置，获取它们之间的距离
            geopos：给定位置，获取经纬度
            georadius：给定自定义经纬度 + 半径 + 单位，获取符合的位置  （直线距离）
            georadiusByMember：给定具体位置 + 半径 + 单位，获取符合的位置 （直线距离）
         */
        //添加经纬度 + 位置
        geoOperations.add("city", new Point(116.512885d,39.847469d),"北京");
        Map<String, Point> map = new HashMap<>();
        map.put("杭州", new Point(120.215512d,30.253083d));
        map.put("广州", new Point(113.333487d,23.08465d));
        map.put("上海", new Point(121.480066d,31.236392d));
        geoOperations.add("city", map);
        //获取某个位置的经纬度
        List<String> cityList = new ArrayList<String>(){{
            add("北京");
            add("杭州");
            add("广州");
            add("上海");
        }};
        List list = geoOperations.position("city", cityList.toArray());//这里value不支持list的原因，是因为redis的序列化的方式不支持
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //给定两个位置，获取它们之间的距离
    }

    @RequestMapping("/test2.do")
    public void test2(){

    }

    @RequestMapping("/test3.do")
    public void test3(){

    }

    @RequestMapping("/test4.do")
    public void test4(){

    }

    @RequestMapping("/test5.do")
    public void test5(){

    }
    @RequestMapping("/test6.do")
    public void test6(){

    }

    @RequestMapping("/test7.do")
    public void test7(){

    }

    @RequestMapping("/test8.do")
    public void test8(){

    }

    @RequestMapping("/test9.do")
    public void test9(){

    }

    @RequestMapping("/test10.do")
    public void test10(){

    }

    @RequestMapping("/test11.do")
    public void test11(){

    }
    @RequestMapping("/test12.do")
    public void test12(){

    }


}
