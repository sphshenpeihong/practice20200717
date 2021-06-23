package com.sph.practice.test.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
public class KafkaConsumerDemo {

    /**
     * 订阅主题，进行消费(poll 拉取的方式)
     */
    @Test
    public void consumerSimple() {
        KafkaConsumer<String, Integer> consumer = getConsumer();
        consumer.subscribe(Collections.singletonList(KafkaProducerDemo.topic1));
        // 每800毫秒拉取一次
        while (true) {
            ConsumerRecords<String, Integer> consumerRecords = consumer.poll(Duration.ofMillis(800));
            for (ConsumerRecord<String, Integer> consumerRecord : consumerRecords) {
                // 打印拉取到的值
                System.out.println("值来了：" + consumerRecord.value());
            }
        }
    }

    /**
     * 获取消费者配置
     *
     * @return
     */
    private Properties getProp() {
        Properties properties = new Properties();
        // 连接kafka地址和端口
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.122.129:9092");
        // 指定key的反序列化器
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // 指定value的反序列化器
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        // 开启自动提交offset的按钮
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        // 拉取到数据后，延迟多少ms后去提交offset的值
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // 定义消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "okok");
        return properties;
    }

    /**
     * 获取消费者对象
     *
     * @return
     */
    private KafkaConsumer<String, Integer> getConsumer() {
        Properties prop = getProp();
        KafkaConsumer<String, Integer> consumer = new KafkaConsumer<>(prop);
        return consumer;
    }


}
