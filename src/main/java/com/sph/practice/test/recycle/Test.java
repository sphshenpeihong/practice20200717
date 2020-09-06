package com.sph.practice.test.recycle;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sph.practice.test.bean.UserParam;

import java.util.*;

/**
 * Created by Shen Peihong on 2020/8/31 11:24
 * Description:
 *
 * @since 1.0.0
 */
public class Test {

    /**
     * list里面的String经过去重处理
     */
    @org.junit.Test
    public void test(){
        List<String> list = Lists.newArrayList("111", "222", "333","111");
        System.out.println(list);
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }

    /**
     *
     */
    @org.junit.Test
    public void test1(){
        List<String> list = Lists.newArrayList("111", "222", "333","111");
        List<String> list1 = Lists.newArrayList("666");
        list.addAll(list1);
        list.add(null);
        System.out.println(list);
    }

    /**
     *
     */
    @org.junit.Test
    public void test2(){
        List<Object> finalList = Lists.newArrayList();
        List<String> list = Lists.newArrayList("111", "222", "333","111");
        List<String> list1 = Lists.newArrayList("666");
        list.addAll(list1);
        finalList.addAll(Sets.newHashSet(list));
        System.out.println(finalList);
    }

    /**
     *  测试看看一个类类型实例化，操作会更换到吗
     */
    @org.junit.Test
    public void test3(){
        UserParam userParam = new UserParam();
        List<UserParam> list = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            userParam.setId(""+i);
            list.add(userParam);
        }
        for (UserParam o : list) {
            System.out.println(o.getId());
        }

    }

    /**
     *  indexOf
     */
    @org.junit.Test
    public void test4(){
        String temp = "";
        String str = "123|456|789";
        if (str != "") {
            int x = str.indexOf("|");
            if (x > 0) {
                if ("".equals(temp)) {
                    temp = str.substring(x + 1, str.length());
                } else {
                    temp = temp + "，" + str.substring(x + 1, str.length());
                }
            }
        }
        System.out.println(temp);
    }

    /**
     *  map的remove
     */
    @org.junit.Test
    public void test5(){
        Map<String, Object> map = Maps.newHashMap();
        map.put("username","123");
        map.remove("username","123");
        System.out.println(map.get("username"));
    }

}
