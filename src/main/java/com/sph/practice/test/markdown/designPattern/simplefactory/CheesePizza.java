package com.sph.practice.test.markdown.designPattern.simplefactory;

/**
 * Created by Shen Peihong on 2020/11/22 9:43
 * Description:
 *
 * @since 1.0.0
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("CheesePizza准备食材");
    }
}
