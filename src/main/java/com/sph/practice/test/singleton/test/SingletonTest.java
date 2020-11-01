package com.sph.practice.test.singleton.test;

import com.google.common.collect.Lists;
import com.sph.practice.test.param.BankVO;
import com.sph.practice.test.param.ResultVO;
import com.sph.practice.test.param.StudentVO;
import com.sph.practice.test.singleton.Hungry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shen Peihong on 2020/10/18 0:20
 * Description:测试单例模式
 *
 * @since 1.0.0
 */
public class SingletonTest {

    /**
     * 测试恶汉式单例
     */
    @Test
    public void test(){
        //单线程情况下，使用类去获取实例，是同一个
        Hungry hungry = Hungry.getInstance(); //局部变量放栈中，获取的对象放本类实例的堆中
        Hungry hungry1 = Hungry.getInstance(); //又获取了一次，局部变量放入栈中，获取的对象
        Hungry hungry2 = Hungry.getInstance(); //又获取了一次，局部变量放入栈中，获取的对象
        Hungry hungry3 = Hungry.getInstance(); //又获取了一次，局部变量放入栈中，获取的对象
        System.out.println(hungry);
        System.out.println(hungry1);
        System.out.println(hungry2);
        System.out.println(hungry3);

    }

    /**
     * 测试不要new对象，而是去获取方法区的对象(获取完会存放到堆中)，
     */
    @Test
    public void test1(){

    }





}
