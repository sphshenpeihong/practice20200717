package com.sph.practice.component.websocket.service;

import org.springframework.stereotype.Service;

import javax.websocket.Session;

/**
 * redis 发布订阅 消息接收器/处理器
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Service
public class RedisReceiver {

    /**
     * redis发布订阅的消息处理器（每增加一个处理器，都需要去增加一个适配器，1对1关系）
     *
     * @param message 消息
     */
    public void receiveMessage(String message) {
        System.out.println("消息处理器1>我处理用户信息：" + message);
        //这里是收到通道的消息之后执行的方法
        //此处执行接收到消息后的 业务逻辑
    }

}
