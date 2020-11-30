package com.sph.practice.test.markdown.designPattern.decorator;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Shen Peihong on 2020/11/28 15:08
 * Description:
 *
 * @since 1.0.0
 */
public class InvokeTest {

    /**
     * 首先购买一杯黑咖啡
     */
    @Test
    public void test1(){
        //声明一定要多态，这里可以声明成Coffee、也可以是Drink
        Drink blackCoffee = new BlackCoffee();
        //获得价格和描述
        System.out.println(blackCoffee.getDesc() + "：" + blackCoffee.getPrice());
        //我们可能需要在黑咖啡里面加一些调料，采用组合的方式
        //因为买调料也是需要花费钱的，所以我们的调料类(装饰者类)也可以去继承Drink类
        //这样一来我们直接采用组合的形式
        //步骤：
        //1、定义装饰者类，成员变量是Drink类型，也即是购买的饮料呢
        //然后还需要自己定义一个price和desc变量(声明调料的价格和描述)
        //还需要提供一个cost方法，用于计算具加完后的具体价格的
        //成员变量的Drink类型提供构造方法注入进来具体的饮料对象
        //这样我们才能计算自己调料的价格的同时，也知道饮料本身的价格了
        Suger order = new Suger(blackCoffee);
        System.out.println("调料的价格：" + order.cost());
        System.out.println("本身的价格：" + order.drink.cost());
        System.out.println(order.drink.getDesc() + "+" + order.getDesc() + "，合计金额为：" + (Float)(order.drink.cost() + order.cost()) );
    }

    /**
     * 看看处理流的底层
     */
    @Test
    public void test2() throws Exception {
        FileOutputStream fos = new FileOutputStream("");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
    }

}
