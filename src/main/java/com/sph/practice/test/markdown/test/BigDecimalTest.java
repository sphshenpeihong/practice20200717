package com.sph.practice.test.markdown.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Shen Peihong on 2020/10/20 16:20
 * Description: BigDecimal
 *
 * @since 1.0.0
 */
public class BigDecimalTest {

    /**
     * add
     */
    @Test
    public void test1(){
        //加法计算
        BigDecimal num = new BigDecimal("1.124");
        BigDecimal num1 = new BigDecimal("1.3644222");
        BigDecimal add = num.add(num1);
        System.out.println(add);
        /*
            2.4884222
         */
    }

    /**
     * subtract
     */
    @Test
    public void test2(){
        //减法计算
        BigDecimal num = new BigDecimal("1.124");
        BigDecimal num1 = new BigDecimal("1.3644222");
        BigDecimal subtract = num.subtract(num1);
        System.out.println(subtract);
        /*
            -0.2404222
         */
    }

    /**
     * multiply
     */
    @Test
    public void test3(){
        BigDecimal num = new BigDecimal("1.234");
        BigDecimal num1 = new BigDecimal("2");
        BigDecimal multiply = num.multiply(num1);
        System.out.println(multiply);
        /*
            2.468
         */
    }

    /**
     * divide
     */
    @Test
    public void test4(){
        BigDecimal num = new BigDecimal("1.234");
        BigDecimal num1 = new BigDecimal("2");
        //arg1：除数
        //arg2：保留几位小数
        //arg3：使用的方式
        //  BigDecimal.ROUND_HALF_UP：四舍五入
        //  BigDecimal.ROUND_UP：向上取整
        //  BigDecimal.ROUND_DOWN：向下取整
        BigDecimal divide = num.divide(num1, 1, BigDecimal.ROUND_HALF_UP);//取一位小数，四舍五入
        System.out.println(divide);
        /*
            0.6
         */
    }

    /**
     * abs
     */
    @Test
    public void test5(){

    }


}
