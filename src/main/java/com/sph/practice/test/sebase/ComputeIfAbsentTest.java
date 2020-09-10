package com.sph.practice.test.sebase;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Shen Peihong on 2020/9/7 23:18
 * Description:Map  ComputeIfAbsent
 *
 * @since 1.0.0
 */
public class ComputeIfAbsentTest {

    /**
     * map的方法，ComputeIfAbsent 这个可以当key不存在，或者该key对应的值为null时，给该key设置一个默认值
     */
    @Test
    public void test(){
        Map<String, Object> map = Maps.newHashMap();
        map.put("username", "zhangsan");
        map.put("password", null);
        System.out.println(map.get("username"));

        System.out.println("username：" + map.computeIfAbsent("username", k -> "username"));
        System.out.println(map.computeIfAbsent("password", k -> "123123"));
        System.out.println("123123");
    }
}
