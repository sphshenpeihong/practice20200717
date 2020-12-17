package com.sph.practice.test.markdown.designPattern.observer;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/12/11 22:57
 * Description:
 *
 * @since 1.0.0
 */
public class Client {

    /**
     *
     */
    @Test
    public void test1(){
        //新建主题对象
        Subject subject = new ConcreteSubject();
        //新建观察者对象
        Observer observer = new ConcreteObserver();
        subject.addObserver(observer);
        subject.removeObserver(null);
        subject.update();
    }


}
