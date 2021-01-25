package com.sph.practice.test.sebase.util;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Shen Peihong on 2020/9/29 17:00
 * Description:
 *
 * @since 1.0.0
 */
public class ObjectUtil1 {

    public ObjectUtil1 ObjectTest(){
        ObjectUtil1 util1 = this;
        System.out.println(util1);
        System.out.println("123123");
        return this;
    }

    //写一个switch 分数阶段

    /**
     *
     */
    @Test
    public void test(){
        //写一个switch
        switch ("123"){
            case "123" : System.out.println("123"); break;
            case "456" : System.out.println("456"); break;
            case "789" : System.out.println("789"); break;
            default: System.out.println("没有一个匹配的");
        }
    }







}
