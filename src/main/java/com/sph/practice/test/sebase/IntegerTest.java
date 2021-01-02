package com.sph.practice.test.sebase;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/12/26 22:47
 * Description:
 *
 * @since 1.0.0
 */
public class IntegerTest {

    /**
     *
     */
    @Test
    public void test1(){
        Integer i = 1;
    }

    /**
     *
     */
    @Test
    public void test2(){
        Integer i = Integer.valueOf(1);
    }

    /**
     * Java编译成.class文件 然后传输给JVM的话，是使用栈指令
     */
    @Test
    public void test3(){
        Integer i1 = 1;
        int i2 = 1;
        System.out.println(i1==i2);
    }

    /**
     *
     */
    @Test
    public void test4(){

    }

}
