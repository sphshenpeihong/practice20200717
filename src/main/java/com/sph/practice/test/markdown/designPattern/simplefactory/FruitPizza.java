package com.sph.practice.test.markdown.designPattern.simplefactory;

/**
 * Created by Shen Peihong on 2020/11/22 9:44
 * Description:
 *
 * @since 1.0.0
 */
public class FruitPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("FruitPizza准备食材");
    }
}
