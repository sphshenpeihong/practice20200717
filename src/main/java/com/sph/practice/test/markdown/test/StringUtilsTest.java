package com.sph.practice.test.markdown.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/10/20 14:20
 * Description:StringUtils工具类
 *
 * @since 1.0.0
 */
public class StringUtilsTest {

    /**
     * StringUtils.isEmpty(str); //当字符串为null或length=0时，返回true
     */
    @Test
    public void test(){
        String str = "test";
        if (StringUtils.isEmpty(str)){
            System.out.println("该字符串为null或为空串");
        }
    }

    /**
     * StringUtils.isNotEmpty(str);  //和上面相反
     */
    @Test
    public void test1(){
        String str = "test";
        if (StringUtils.isNotEmpty(str)){
            System.out.println("当前字符串既不为null，也不为空串");
        }
    }

    /**
     * StringUtils.isBlank(str);  //是否是null或length=0或空白符
     */
    @Test
    public void test2(){
        String str = "test";
        if (StringUtils.isBlank(str)){
            System.out.println("当前字符串为null 或 长度为0(空串) 或 全为空白符 ");
        }
    }

    /**
     * 4.String：StringUtils.trim(str);  //去掉前后两端的空格，用法和String的trim()差不多
     */
    @Test
    public void test3(){
        String str = " test ";
        String trim = StringUtils.trim(str);//去掉前后两端的空格，用法和String的trim()差不多
        System.out.println(trim);
        /*
            test
         */
    }

    /**
     * 5.boolean StringUtils.equalsIgnoreCase(str1,str2); //判断是否相等，无论大小写
     */
    @Test
    public void test4(){
        String str1 = "test";
        String str2 = "Test";
        if (StringUtils.equalsIgnoreCase(str1, str2)) {
            System.out.println("已匹配上");//判断是否相等，无论大小写
        } else {
            System.out.println("未匹配上");
        }
    }

    /**
     * 7.boolean：isAnyEmpty(str1,str2,str3); //如果任意一个为空，则为true
     */
    @Test
    public void test5(){
        String str1 = "test";
        String str2 = null;
        if (StringUtils.isAnyEmpty(str1, str2)) {
            System.out.println("存在至少一个字符串为null 或 字符串长度为0");
        } else {
            System.out.println("所有字符串都不为null 并且 字符串长度都大于0");
        }
    }

    /**
     *
     */
    @Test
    public void test6(){

    }

    /**
     *
     */
    @Test
    public void test7(){

    }

    /**
     *
     */
    @Test
    public void test8(){

    }

    /**
     *
     */
    @Test
    public void test9(){

    }

}
