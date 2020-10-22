package com.sph.practice.test.markdown.test;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by Shen Peihong on 2020/10/21 0:49
 * Description: Optional
 *
 * @since 1.0.0
 */
public class OptionalTest {

    /**
     *
     */
    @Test
    public void test1(){
        String test = null;
        String str = Optional.ofNullable(test).orElse("123");
        System.out.println(str);
        /*
            123
         */

    }

    /**
     *
     */
    @Test
    public void test2(){

    }

    /**
     *
     */
    @Test
    public void test3(){

    }

    /**
     *
     */
    @Test
    public void test4(){

    }

    /**
     *
     */
    @Test
    public void test5(){

    }

}
