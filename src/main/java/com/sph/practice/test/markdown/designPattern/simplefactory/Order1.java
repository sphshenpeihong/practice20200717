package com.sph.practice.test.markdown.designPattern.simplefactory;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/11/22 9:51
 * Description: 下单类，供其它对象进行下单
 *
 * @since 1.0.0
 */
public class Order1 {

    //提供构造方法，用户可以创建订单对象进行下单
    public Order1(String orderType){
        Pizza pizza = SimpleFactory.handlePizza(orderType);
        pizza.prepare();
        pizza.bake();
        pizza.pack();
    }

}

class Test1{

    //用户下单
    public static void main(String[] args) {
        Order1 cheesePizza = new Order1("CheesePizza");
    }

}
