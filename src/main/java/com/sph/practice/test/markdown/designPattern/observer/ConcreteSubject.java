package com.sph.practice.test.markdown.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen Peihong on 2020/12/11 22:45
 * Description:
 *
 * @since 1.0.0
 */
public class ConcreteSubject implements Subject{

    //观察者注册
    private List<Observer> observerList;

    //创建对象的时候，去初始化成员遍历
    public ConcreteSubject() {
        observerList = new ArrayList<Observer>();
    }

    //提供注册添加观察者
    @Override
    public void addObserver(Observer observer){
        this.observerList.add(observer);
        System.out.println("注册观察者成功");
    }

    //销毁观察者
    @Override
    public void removeObserver(Observer observer){
        if (observer == null || !observerList.contains(observer)){
            return;
        }
        observerList.remove(observer);
        System.out.println("销毁观察者成功");
    }

    @Override
    public void update() {
        this.inform();
    }

    @Override
    public void inform() {
        //通知各个观察者了。
        for (Observer observer : observerList) {
            observer.receive();
        }
    }


}
