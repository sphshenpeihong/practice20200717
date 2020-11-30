package com.sph.practice.test.markdown.designPattern.decorator;

/**
 * Created by Shen Peihong on 2020/11/28 15:18
 * Description: 因为本身装饰者类也需要定义和Drink类一样的变量以及方法，所以这里直接继承就行
 *
 * @since 1.0.0
 */
public class Decorator extends Drink{

    protected Drink drink;

    //接收具体的饮料对象
    public Decorator(Drink drink) {
        this.drink = drink;
    }

    //获取调料的价格
    @Override
    public Float cost() {
        return super.getPrice();
    }
}
