package com.sph.practice.test.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.junit.Test;

import java.util.Properties;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
public class KafkaDemo {


    /**
     * 直接new一个kafka生产者对象，去调用send方法下发数据到kafka消息队列中
     */
    @Test
    public void test1(){
        // 1、创建kafka生产者的配置信息
        Properties properties = new Properties();
        // 2、指向某台broker
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.122.128:9092");
        // 3、ACK应答级别
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        // 4、错误重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 1);
        // 5、批次大小，单位字节：16KB  （只要RecordAccumulator满16KB，Sender线程就会读取，然后放到RecordAccumulator缓冲区中）
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        // 等待时间，单位毫秒
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);


        // 新建生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
    }

}
