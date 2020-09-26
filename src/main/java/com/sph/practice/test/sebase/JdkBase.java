package com.sph.practice.test.sebase;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

/**
 * Created by Shen Peihong on 2020/9/16 22:03
 * Description: 测试一些比如map 匿名内部类 以及一些lambda表达式 filter
 *
 * @since 1.0.0
 */
public class JdkBase {

    private String test111 = "test111";

    /**
     * 匿名内部类里面的构造块，可以访问外部变量，但是基本类型只能访问不能修改，但是引用类型既能访问又能修改
     */
    @Test
    public void test(){
        List<String> list = Lists.newArrayList();
        list.add("111");
        list.add("222");
        list.add("333");
        String test = "666";

        Map<String, Object> map = new HashMap<String, Object>() {{
            put("username","123");
            put("password",test);
            put("sex",test111);
            list.add("999");
        }};
        System.out.println(list);
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }

    /**
     * LinkedList
     */
    @Test
    public void test1(){

    }

}
