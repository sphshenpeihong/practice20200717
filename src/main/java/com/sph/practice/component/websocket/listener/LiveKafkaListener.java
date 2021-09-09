package com.sph.practice.component.websocket.listener;

import com.alibaba.fastjson.JSON;
import com.sph.practice.component.websocket.pojo.bo.LiveCommentBO;
import com.sph.practice.component.websocket.service.WebsocketClusterServer;
import com.sph.practice.component.websocket.util.WebsocketUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Kafka
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Component
@Slf4j
public class LiveKafkaListener {

    /**
     * 处理用户直播评论
     *
     * @param record 消息数据
     * @param ack    ack对象
     * @param topic  主题对象
     */
    @KafkaListener(topics = WebsocketUtil.TOPIC_LIVE_COMMENT, groupId = "${kafka.groupId}")
    public void handlleLiveComment(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("处理用户直播评论，record = {}", record.value().toString());
        // 手动提交offset
        // ack.acknowledge();
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            LiveCommentBO commentBO = JSON.parseObject((String) message.get(), LiveCommentBO.class);
            WebsocketClusterServer.sendMessage(commentBO.getLiveId(), commentBO.getUserId(), commentBO.getMessage());
        }
    }

}
