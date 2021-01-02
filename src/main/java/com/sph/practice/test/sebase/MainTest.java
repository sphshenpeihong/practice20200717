package com.sph.practice.test.sebase;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen Peihong on 2020/12/26 23:32
 * Description:
 *
 * @since 1.0.0
 */
public class MainTest {

    private static Integer i = 0;

    private static int num = 1;

    //类加载（链接中的准备阶段时）的时候，不会全部类都去加载，而是只加载一些需要加载的类呢。
    //其它类是延迟加载，需要的时候才去用类加载器去加载的呢。
    static {
        System.out.println("嘿猪。");
        num = 2;

    }

    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println(num);
    }

    /**
     *
     */
    @Test
    public void test1(){
        System.out.println("123 ");
        List<String> list = Lists.newArrayList("123");
        this.invoke1(list);
        System.out.println("456");
    }

    private void invoke1(List<String> list){
        list.add("456");
        System.out.println("invoke1");
        this.invoke2();
    }

    private void invoke2(){
        System.out.println("invoke2");
    }

}
