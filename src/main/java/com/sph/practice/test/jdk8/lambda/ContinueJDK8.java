package com.sph.practice.test.jdk8.lambda;

import com.sph.practice.test.bean.User1;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/7/2 13:42
 * Description: 继续练习一下lambda表达式提供的接口 stream(). 流式方法
 *
 * @since 1.0.0
 */
public class ContinueJDK8 {

    /**
     * sorted()
     */
    @Test
    public void test01(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(list);
        list.stream().sorted().forEach(System.out::println); //用方法引用的方式
    }

    /**
     * 练习一下Collectos.joining()
     */
    @Test
    public void test03(){
        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        String collect = list.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

    }

    /**
     * 练习一下Collectos.grouping() 这个方法分别有三个重载方法
     */
    @Test
    public void test04(){
        //List<VO类> 对某个元素进行分组，返回是一个Map类型，左边是分组类型，右边是分组后的值，类型是List<原来的VO类型>   一个参数的话默认就是右边是List类型的
        List<User1> list = new ArrayList<>();
        User1 u1 = new User1(1,"zhangsan","zhangsan",-1);
        User1 u2 = new User1(2,"zz","zz",1);
        User1 u3 = new User1(3,"ww","ww",1);
        User1 u4 = new User1(4,"dd","dd",-1);
        User1 u5 = new User1(5,"cc","cc",-1);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        Map<Integer, List<User1>> collect = list.stream().collect(Collectors.groupingBy(User1::getParentId)); //

    }

}
