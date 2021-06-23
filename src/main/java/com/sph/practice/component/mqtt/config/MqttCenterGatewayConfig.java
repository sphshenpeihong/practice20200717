/*
package com.sph.practice.component.mqtt.config;

import com.sph.practice.component.mqtt.properties.MqttCenterGatewayProperties;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

*/
/**
 * 〈一句话功能简述〉<br>
 * 〈MQTT接收消息处理〉
 *
 * @author lenovo
 * @create 2018/6/4
 * @since 1.0.0
 *//*

@Slf4j
@Configuration
@IntegrationComponentScan
public class MqttCenterGatewayConfig {

    @Resource
    private MqttCenterGatewayProperties centerGatewayProperties;

    @Bean
    public MqttConnectOptions getMqttConnectOptionsForCenter() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(centerGatewayProperties.getUsername());
        mqttConnectOptions.setPassword(centerGatewayProperties.getPassword().toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{centerGatewayProperties.getUrl()});
        mqttConnectOptions.setKeepAliveInterval(2);
        return mqttConnectOptions;
    }

    @Bean
    public MqttPahoClientFactory mqttClientFactoryForCenter() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptionsForCenter());
        return factory;
    }

    //接收通道
    @Bean
    public MessageChannel mqttCenterGatewayChannel() {
        return new DirectChannel();
    }

    // 配置client,监听的topic
    @Bean
    public MessageProducer centerGatewayReceiverProducer() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(centerGatewayProperties.getClientId(), mqttClientFactoryForCenter(),
                                                        centerGatewayProperties.getDefaultTopic());
        adapter.setCompletionTimeout(centerGatewayProperties.getCompletionTimeout());
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttCenterGatewayChannel());
        return adapter;
    }

    String format = "yyyy-MM-dd HH:mm:ss SSS";

    @Bean
    @ServiceActivator(inputChannel = "mqttCenterGatewayChannel")
    public MessageHandler centerGatewayReceiverHandler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
                String type = topic.substring(topic.lastIndexOf("/") + 1, topic.length());
                if (centerGatewayProperties.getDefaultTopic().equalsIgnoreCase(topic)) {
                    log.info("监听入口时间：" + new SimpleDateFormat(format).format(new Date()));
                    log.info("监听数据为：" + message.getPayload().toString());
                }
            }
        };
    }

    // 下面配置一下推送数据，共用一个通道
    @Bean
    @ServiceActivator(inputChannel = "mqttCenterGatewayChannel")
    public MessageHandler centerGatewaySenderHandler() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(centerGatewayProperties.getClientId(), mqttClientFactoryForCenter());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(centerGatewayProperties.getDefaultTopic());
        return messageHandler;
    }
}*/
