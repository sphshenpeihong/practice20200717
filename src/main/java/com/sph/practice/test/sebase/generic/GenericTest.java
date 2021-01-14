package com.sph.practice.test.sebase.generic;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2021/1/2 23:45
 * Description:
 *
 * @since 1.0.0
 */
public class GenericTest {

    /**
     *
     */
    @Test
    public void test1(){
        Generic1<String> generic1 = new Generic1<>();
        generic1.print("123");
    }

    /**
     *
     */
    @Test
    public void test2(){
        Generic2.print("213");
    }

}
