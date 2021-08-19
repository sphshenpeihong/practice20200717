package com.sph.practice.component.websocket.controller;

import com.sph.practice.component.websocket.util.WebsocketUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.websocket.WsSession;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.DeploymentException;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@RestController
@Slf4j
public class WebsocketController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * redis 发布订阅pubsub
     */
    @RequestMapping(value = "/redisPubSub")
    public void redisPubSub(String msg) throws DeploymentException {
        redisTemplate.convertAndSend(WebsocketUtil.USER, msg);
    }

}
