package com.sph.practice.test.sebase;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Shen Peihong on 2020/7/23 17:40
 * Description: 练习Atomic
 *
 * @since 1.0.0
 */
public class AtomicLongTest {

    @Test
    public void test1(){
        //Number类类型是许多数值类型的父类
        //创建一个原子型Integer
        AtomicInteger num = new AtomicInteger(1);
        System.out.println(num);
    }



    /**
     * byte转int
     */
    @Test
    public void test2(){
        for (byte i = 0; i < 127; i++) {
            System.out.println(i);
        }
    }

}
