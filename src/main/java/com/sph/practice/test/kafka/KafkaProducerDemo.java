package com.sph.practice.test.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
@Slf4j
public class KafkaProducerDemo {

    // 定义topic主题
    private static final String topic = "frist";

    public static final String topic1 = "test20210614a";

    /**
     * 1、直接new一个kafka生产者对象，去调用send方法下发数据到kafka消息队列中
     * 注：kafka的send方法里边的底层代码是main线程直接把信息推送到RecordAccumulator中
     * 然后可能批处理满了或者执行时间到了，Sender线程就会将RecordAccumulator里边的消息推至kafka
     * （所以我们执行send方法的时候，完全不需要去异步执行）
     */
    @Test
    public void asyncSend() {
        // 获取生产者对象
        KafkaProducer<String, Object> producer = getProducer();
        // 封装消息对象
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topic, "123");
        // 推送消息
        producer.send(producerRecord);
    }

    /**
     * 2、异步推送，并带回调函数
     */
    @Test
    public void asyncSendAndCallback() throws InterruptedException {
        // 获取生产者对象
        KafkaProducer<String, Object> producer = getProducer();
        // 封装消息对象
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topic, "123");
        // 异步推送消息，并带回调函数
        producer.send(producerRecord, (metadata, exception) -> {
            log.info("当前子线程为：name = {}", Thread.currentThread().getName());
        });
        System.out.println("主线程执行完毕");
        // 阻塞主线程
        TimeUnit.SECONDS.sleep(10);
    }

    // 异步推送，send()函数的返回值是future，我们可以调用get方法来获得返回值(同步阻塞)

    /**
     *
     */
    @Test
    public void syncAcceptMetadata() throws ExecutionException, InterruptedException {
        // 获取生产者对象
        KafkaProducer<String, Object> producer = getProducer();
        // 封装消息对象
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topic, "123");
        // 推送消息
        Future<RecordMetadata> future = producer.send(producerRecord);
        // 使主线程进入同步阻塞
        RecordMetadata metadata = future.get();
        log.info("partition：{} --- offset：{}", metadata.partition(), metadata.offset());
        // 阻塞主线程
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * 循环异步推送，并且在回调函数中打印出分区和分区内的offset
     */
    @Test
    public void cycleSend() throws InterruptedException {
        // 获取生产者对象
        KafkaProducer<String, Object> producer = getProducer();
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (int i = 0; i < 10; i++) {
            // 封装消息对象
            // 如果涉及到多个分区，那么需要提前在服务器先创建好主题，并划分好分区和副本
            ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topic1, 0, list.get(i % 3), i);
            producer.send(producerRecord, (metaData, exception) -> {
                log.info("当前子线程name = {}", Thread.currentThread().getName());
                log.info("partition = {} --- offset = {}", metaData.partition(), metaData.offset());
            });
        }
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * 获取KafkaProducer对象
     *
     * @return 返参
     */
    private KafkaProducer<String, Object> getProducer() {
        return new KafkaProducer<>(getKafkaProp());
    }

    /**
     * 获取Kafka的相关属性配置
     *
     * @return
     */
    private Properties getKafkaProp() {
        // 1、创建kafka生产者的配置信息
        Properties properties = new Properties();
        // 2、指向某台broker
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.122.129:9092,192.168.122.129:9093,192.168.122.129:9094");
        // 3、ACK应答级别
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        // 4、错误重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 1);
        // 5、批次大小，单位字节：16KB  （只要RecordAccumulator满16KB，Sender线程就会读取，然后放到RecordAccumulator缓冲区中）
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        // 等待时间，单位毫秒
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        // key的序列化器
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // value的序列化器
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        return properties;
    }


}
