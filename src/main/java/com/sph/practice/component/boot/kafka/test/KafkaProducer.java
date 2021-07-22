package com.sph.practice.component.boot.kafka.test;

import com.alibaba.fastjson.JSONObject;
import com.sph.practice.component.boot.kafka.constant.TopicConstant;
import com.sph.practice.component.boot.kafka.util.KafkaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;


/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */

@Component
@Slf4j
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    // 根据接口文档，模拟数据，调通接口
    public void send(Object obj) throws Exception {
        String obj2String = JSONObject.toJSONString(obj);
        log.info("准备发送消息为：{}", obj2String);

        byte[] bytes = KafkaUtil.convertObjToBytes(obj);
        //发送消息
        ListenableFuture<SendResult<String, byte[]>> future = kafkaTemplate.send(TopicConstant.TOPIC_PassersByCapture, bytes);
        future.addCallback(new ListenableFutureCallback<SendResult<String, byte[]>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                log.info(TopicConstant.TOPIC_PassersByCapture + " - 生产者 发送消息失败：" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, byte[]> stringObjectSendResult) {
                //成功的处理
                log.info(TopicConstant.TOPIC_PassersByCapture + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
        });
    }















/*    public void send(Object obj) {
        String obj2String = JSONObject.toJSONString(obj);
        log.info("准备发送消息为：{}", obj2String);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TopicConstant.TOPIC_TEST, obj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                log.info(TopicConstant.TOPIC_TEST + " - 生产者 发送消息失败：" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //成功的处理
                log.info(TopicConstant.TOPIC_TEST + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
        });
    }*/
}
