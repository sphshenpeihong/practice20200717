package com.sph.practice.test.markdown.designPattern.decorator;

/**
 * Created by Shen Peihong on 2020/11/28 15:00
 * Description: 由于咖啡有很多种类，所以这里仍然利用多态的特性，先定义一个咖啡父类
 *
 * @since 1.0.0
 */
public class Coffee extends Drink {

    //这里只是一个咖啡父类，并不知道各种咖啡的价格，所以setPrice这个方法必须等知道具体咖啡的价格再去操作了
    //所以我们这里直接返回成员变量的价格即可，这里不涉及到各种计算，所以我们直接返回price这个变量的值
    //因为我们所花费的，就是这个价格的成员变量了
    //父类这里已经重写该方法了，子类去继承的时候，也就不需要再去重写cost方法了，子类想知道花费的价格的话
    //可以有两种方式，一种是直接super.getPrice() 一种是调用父类cost方法，因为父类已重写
    //注：是因为这里恰好购买饮料所花费的价格刚好和成员变量price一样，才能采用super.getPrice()的方法，正规一定还是的通过调重写方法的形式呢
    //子类去set父类成员变量的时机可以是在方法里，构造方法里，构造块里，静态代码块里，具体看情况了
    @Override
    public Float cost() {
        return super.getPrice();
    }
}
