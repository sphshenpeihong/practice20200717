package com.sph.practice.test.markdown.designPattern.decorator;

/**
 * Created by Shen Peihong on 2020/11/28 15:21
 * Description:
 *
 * @since 1.0.0
 */
public class Suger extends Decorator {

    //因为父类定义了构造方法，直接使用父类的构造方法即可
    public Suger(Drink drink) {
        super(drink);
        super.setPrice(0.5f);
        super.setDesc("糖");
    }


}
