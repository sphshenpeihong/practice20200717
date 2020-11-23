package com.sph.practice.test.markdown.designPattern.simplefactory;

/**
 * Created by Shen Peihong on 2020/11/22 9:44
 * Description: 简单工厂，专门封装处理披萨的全过程，供订单类使用
 *
 * @since 1.0.0
 */
public class SimpleFactory {

    //入参：披萨类型
    //出餐：Pizza
    //过程简述：通过入参类型，到时候制作好披萨，并返回 （定义成静态的，外部使用可以通过类名调用）
    public static Pizza handlePizza(String orderType){
        if ("CheesePizza".equals(orderType)){
            //创建空对象
            Pizza pizza = new CheesePizza();
            return pizza;
        }else if ("Fruit".equals(orderType)){
            //创建空对象
            Pizza pizza = new FruitPizza();
            return pizza;
        }else{
            System.out.println("抱歉，当前没有这种类型的披萨");
            return null;
        }
    }

}
