/*
package com.sph.practice.component.mqtt.config;

import com.sph.practice.component.mqtt.properties.MqttEdgeGatewayProperties;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
 * 〈MQTT发送消息配置〉
 *
 * @author AnswerChang
 * @create 2018/6/4
 * @since 1.0.0
 *//*

@Slf4j
@Configuration
@IntegrationComponentScan
public class MqttEdgeGatewayConfig {

    @Resource
    private MqttEdgeGatewayProperties edgeGatewayProperties;

    */
/**
 * MQTT连接对象
 *
 * @return MQTT连接对象bean
 *//*

    @Bean
    public MqttConnectOptions getMqttConnectOptionsForEdge() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(edgeGatewayProperties.getUsername());
        mqttConnectOptions.setPassword(edgeGatewayProperties.getPassword().toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{edgeGatewayProperties.getUrl()});
        mqttConnectOptions.setKeepAliveInterval(90);
        mqttConnectOptions.setCleanSession(false);
*/
/*        mqttConnectOptions.setConnectionTimeout(10);
        mqttConnectOptions.setCleanSession(true);
        mqttConnectOptions.setAutomaticReconnect(true);*//*

        return mqttConnectOptions;
    }

    */
/**
 * MQTT对象工厂
 *
 * @return MQTT对象工厂bean
 *//*

    @Bean
    public MqttPahoClientFactory mqttClientFactoryForEdge() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptionsForEdge());
        return factory;
    }

    */
/**
 * MQTT传输通道   (发布通道)
 *
 * @return MQTT传输通道bean
 *//*

    @Bean
    public MessageChannel mqttEdgeGatewayChannel() {
        log.info("建立发布通道");
        return new DirectChannel();
    }

    */
/**
 * MQTT传输通道   (订阅通道)
 *
 * @return MQTT传输通道bean
 *//*

    @Bean
    public MessageChannel mqttEdgeGatewayReceiverChannel() {
        log.info("建立订阅通道");
        return new DirectChannel();
    }

    */
/**
 * 往推送数据通道推送数据的Handler处理器（相当于客户端，多个客户端的clientId不能重复）
 * 注：如果clientId重复，那么会自动断掉已连接成功的客户端
 *
 * @return 消息处理器
 *//*

    @Bean
    @ServiceActivator(inputChannel = "mqttEdgeGatewayChannel")
    public MessageHandler edgeGatewaySenderHandler() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(edgeGatewayProperties.getClientId(), mqttClientFactoryForEdge());

        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(edgeGatewayProperties.getDefaultTopic());
        return messageHandler;
    }


    // 下面配置一下监听数据
    // 配置client,监听的topic
    @Bean
    public MessageProducer centerGatewayReceiverProducer() {

        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(edgeGatewayProperties.getClientId(), mqttClientFactoryForEdge(),
                                                        "M988OTSSKV/XRay1/data5/+/22");
        adapter.setCompletionTimeout(edgeGatewayProperties.getCompletionTimeout());
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttEdgeGatewayReceiverChannel());
        return adapter;
    }

    String format = "yyyy-MM-dd HH:mm:ss SSS";

    @Bean
    @ServiceActivator(inputChannel = "mqttEdgeGatewayReceiverChannel")
    public MessageHandler centerGatewayReceiverHandler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
                String type = topic.substring(topic.lastIndexOf("/") + 1, topic.length());
                if (edgeGatewayProperties.getDefaultTopic().equalsIgnoreCase(topic)) {
                    log.info("监听入口时间：" + new SimpleDateFormat(format).format(new Date()));
                    log.info("监听数据为：" + message.getPayload().toString());
                }
            }
        };
    }
}*/
