package com.sph.practice.test.markdown.test;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Shen Peihong on 2020/10/20 22:43
 * Description: Calendar
 *
 * @since 1.0.0
 */
public class CalendarTest {

    /**
     *
     */
    @Test
    public void test1(){
        Calendar instance = Calendar.getInstance();
        Date now = instance.getTime();
        System.out.println(now);
        /*
            Tue Oct 20 22:47:33 CST 2020
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
