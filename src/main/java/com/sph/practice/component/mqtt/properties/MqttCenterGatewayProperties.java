/*
package com.sph.practice.component.mqtt.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

*/
/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 *//*

@Data
@Component
@ConfigurationProperties(prefix = "mqtt.center")
public class MqttCenterGatewayProperties {
    */
/**
 * 连接mqtt地址
 *//*

    private String url;

    */
/**
 * 用户名
 *//*

    private String username;

    */
/**
 * 密码
 *//*

    private String password;

    */
/**
 * clientId
 *//*

    private String clientId;

    */
/**
 * 默认主题
 *//*

    private String defaultTopic;

    */
/**
 * 连接超时时间
 *//*

    private Integer completionTimeout;
}
*/
