package com.sph.practice.test.markdown.designPattern.decorator;

/**
 * Created by Shen Peihong on 2020/11/28 14:55
 * Description: 饮料父类
 *
 * @since 1.0.0
 */
public abstract class Drink {

    //这里不能定义有参的构造方法，因为我们的类的级别可能大于或等于三级，这样子类都得去写构造方法了
    //所以提供get set方法就行，因为本身成员变量也是定义成私有的了，要想子类可以访问的话，一定得提供对外可以访问到变量的方法
    private Float price;
    private String desc;

    //定义一个抽象方法，知道饮料多少钱，子类一定要去重写这个抽象方法，这样一来才能提供知道价钱的方法

    public abstract Float cost();

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
