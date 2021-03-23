package com.sph.practice.component.boot.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by Shen Peihong on 2021/3/4
 * Description:
 *
 * @since 1.0.0
 */
@Service
public class ApplicationListenerServiceImpl {

    @EventListener
    public void getEvent(ApplicationEvent event){
        //System.out.println("使用注解去接收实现，收到了" + event);
    }
}
