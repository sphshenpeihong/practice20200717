package com.sph.practice.component.boot.event;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * Created by Shen Peihong on 2021/3/4
 * Description:
 *
 * @since 1.0.0
 */
@Component
public class ReceiveMessageOfBeansCreated implements SmartInitializingSingleton {
    /*
        概述：创建完定义的beans后，会容器中是否存在实现了这个接口，如果有实现这个接口的话，那么会调用里面的重写方法
        作用：相当于某一个时机到达的时候，就会调用这个接口实现类的重写方法呢
     */
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("兄dei，beans都创建完后，记得调用我这个方法告诉我一声哦");
    }
}
