package com.sph.practice.test.markdown.designPattern.observer;

/**
 * Created by Shen Peihong on 2020/12/11 22:45
 * Description: 主题接口
 *
 * @since 1.0.0
 */
public interface Subject {

    //供用户调的更新接口
    public void update();

    //负责发送的
    //定义通知接口，负责通知
    void inform();

    //注册添加观察者
    void addObserver(Observer observer);

    //销毁观察者
    void removeObserver(Observer observer);

}
