package com.sph.practice.test.sebase;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/11/26 15:46
 * Description: NumberUtils工具类的使用练习
 *
 * @since 1.0.0
 */
public class NumberUtilsTest {

    /**
     * NumberUtils.isNumber()
     * 判断传入的String类型的参数是否是一个数字来的
     */
    @Test
    public void test1(){
        String str = "23123213.12";
        System.out.println(NumberUtils.isNumber(str));
        /*
            true
         */
    }

    /**
     * NumberUtils.isDigits()
     * 判断传入的String类型的参数是否每个字符都为数字
     */
    @Test
    public void test2(){
        String str = "23123213.12";
        System.out.println(NumberUtils.isDigits(str));
        /*
            false
         */
    }

    /**
     * 求最值
     */
    @Test
    public void test3(){
        List<Integer> list = Lists.newArrayList(1, 2, 3, 5, 7, 4);
    }

}
