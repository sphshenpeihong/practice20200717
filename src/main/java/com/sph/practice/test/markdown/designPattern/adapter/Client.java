package com.sph.practice.test.markdown.designPattern.adapter;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/11/27 1:30
 * Description:用户手机进行充电
 *
 * @since 1.0.0
 */
public class Client {

    @Test
    public void test(){
        //手机类提供了进行充电方法，方法的参数需要传进来适配器类对象
        //所以我们需要new一个适配器类对象，使用的是适配器类对象的构造方法，构造方法是有形参的
        //构造方法有形参就意味着需要我们去初始化成员变量(可能成员变量需要进行初始化，不然不进行初始化直接使用的话)
        //会造成空指针异常，故我们才去new U220V()。
        new Phone().charging(new U5V(new U220V()));
    }

}
