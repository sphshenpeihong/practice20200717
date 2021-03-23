package com.sph.practice.component.boot.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Shen Peihong on 2021/3/3
 * Description:
 *
 * @since 1.0.0
 */
/*
    使用一些Spring提供的一些接口功能的一些套路两步骤
    1、实现Spring规定的接口，并且重写方法
    2、然后你这个类也要交给Spring容器管理
    -> 到时候Spring的执行的某个时机，就会去扫描容器哪一些bean实现了这个规定的接口，到时候就会给这批bean调重写方法的呢。
 */

@Component
public class ApplicationListenerEvent implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // System.out.println("定义接口去接收事件，收到了" + event);
    }
}
