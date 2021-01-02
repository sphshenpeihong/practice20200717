package com.sph.practice.test.sebase;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/12/27 14:38
 * Description:
 *
 * @since 1.0.0
 */
public class ContructTest {

    public ContructTest(){
        System.out.println("类被加载的时候，会执行构造方法吗？还是说一定要有对象被实例化才会调用到呢");
    }

    public static void main(String[] args) {
        System.out.println("来骗");
    }

    /**
     *
     */
    @Test
    public void test1(){
        ClassLoader classLoader = ContructTest.class.getClassLoader();
        System.out.println(classLoader);
    }


}
