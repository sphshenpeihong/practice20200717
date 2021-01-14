package com.sph.practice.test.sebase.generic;

/**
 * Created by Shen Peihong on 2021/1/2 23:50
 * Description:
 *
 * @since 1.0.0
 */
public class Generic2 {

    //定义泛型类的话，不能用静态方法
    //所以定义一下泛型方法

    public static <T> void print(T t){

        System.out.println("123123");
    }

}
