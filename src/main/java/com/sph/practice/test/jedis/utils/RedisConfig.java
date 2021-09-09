package com.sph.practice.test.jedis.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sph.practice.component.websocket.service.RedisReceiver;
import com.sph.practice.component.websocket.util.WebsocketUtil;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by Shen Peihong on 2020/9/17 1:49
 * Description: 进行序列化处理
 *
 * @since 1.0.0
 */
@Configuration
/* 指定加载某个配置类后才会加载此类 */
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {

    /**
     * redisTemplate 序列化使用的jdkSerializeable, 存储二进制字节码, 所以自定义序列化类
     *
     * @param redisConnectionFactory redis连接工厂对象
     * @return redisTemplate实例对象
     */
    @Bean
    @SuppressWarnings("unchecked")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        // ObjectMapper映射器支持JSON和JavaBean对象之间互转
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        // 序列化方式
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * redis消息监听器容器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息监听器
     * 通过反射技术调用消息订阅处理器的相关方法进行一些业务处理
     *
     * @param connectionFactory redis连接工厂对象
     * @param listenerAdapter   消息监听器适配器
     * @return 消息监听器
     */
    // 暂时不使用基于redis发布订阅功能
    //@Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        //可以添加多个 messageListener
        //可以对 messageListener对应的适配器listenerAdapter  指定本适配器 适配的消息类型  是什么
        //在发布的地方 对应发布的redisTemplate.convertAndSend("user",msg);  那这边的就对应的可以消费到指定类型的 订阅消息
        container.addMessageListener(listenerAdapter, new PatternTopic(WebsocketUtil.USER));

        return container;
    }


    /**
     * 消息监听器适配器，绑定消息处理器，利用反射技术调用消息处理器的业务方法
     * receiveMessage 是默认监听方法 一般不变
     *
     * @param redisReceiver redis消息处理器，自定义的
     * @return 消息监听器适配器
     */
    @Bean
    MessageListenerAdapter listenerAdapter(RedisReceiver redisReceiver) {
        return new MessageListenerAdapter(redisReceiver, WebsocketUtil.DEAULT_LISTENER_METHOD);
    }

}
