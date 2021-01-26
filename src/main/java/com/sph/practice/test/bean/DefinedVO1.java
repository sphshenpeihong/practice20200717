package com.sph.practice.test.bean;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shen Peihong on 2021/1/26
 * Description:
 *
 * @since 1.0.0
 */
public class DefinedVO1 {

    static{

        System.out.println("不加任何，看看启动的时候是否执行");
    }

    /**
     *
     */
    @Test
    public void test(){
        Map<Object, Object> map = Maps.newHashMap();
        map.put("username","123");
        map.put("password","456");
        String str = JSON.toJSONString(map);
        System.out.println(str);
    }

}
