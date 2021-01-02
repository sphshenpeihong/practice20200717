package com.sph.practice.mybatis.util;

import com.google.common.collect.Lists;
import com.sph.practice.test.param.BankVO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/12/23 17:13
 * Description: 泛型方法
 *
 * @since 1.0.0
 */
public class GenericClass {

    //注释
    public static Integer i = 0;

    /**
     *
     */
    @Test
    public void test1(){
        this.searchByPk(String.class,11);
    }

    //泛型方法
    /*
        <T extends IBaseDBVO> T searchByPk(Class<T> clz, Object id) throws Exception;
     */
    public static <T> String searchByPk(Class<T> clz, Object id){
        System.out.println("12312312");
        return null;
    }

    /**
     *
     */
    @Test
    public void test2(){
        StringBuilder userIds = new StringBuilder(null);
        System.out.println("123123");
        String join = String.join(",", "123","456");
        System.out.println(join);
    }

    /**
     * 试试filter过后，赋给原来的那个list 看看会不会有影响，底层应该是有用一个中间变量 最后可以赋值那种
     */
    @Test
    public void test3(){
        List<String> list = Lists.newArrayList("111", "222","333");
        list = list.stream().filter(po -> "111".equals(po) || "222".equals(po)).collect(Collectors.toList());
        System.out.println(list);
        List<BankVO> list1 = new ArrayList<>();
        list1.add(new BankVO("1","1","1"));
        list1.add(new BankVO("2","2","2"));
        list1.add(new BankVO("3","3","3"));
        list1 = list1.stream().map(e -> {
            if (e.getId().equals("1")) {
                return e;
            }
            return null;
        }).collect(Collectors.toList());
        System.out.println(list1);
    }


}
