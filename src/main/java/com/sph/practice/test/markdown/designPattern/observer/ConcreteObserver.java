package com.sph.practice.test.markdown.designPattern.observer;

/**
 * Created by Shen Peihong on 2020/12/11 22:48
 * Description:
 *
 * @since 1.0.0
 */
public class ConcreteObserver implements Observer {
    @Override
    public void receive() {
        System.out.println("嘿嘿，我接收到了哦");
    }
}
