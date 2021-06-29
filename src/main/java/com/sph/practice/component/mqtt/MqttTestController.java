/*
package com.sph.practice.component.mqtt;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.sph.practice.test.param.MqttDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

*/
/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 *//*

@RestController
@RequestMapping("/mqtt")
@Slf4j
public class MqttTestController {

    String format = "yyyy-MM-dd HH:mm:ss SSS";

    @Resource
    private MqttGateway mqttGateway;

    @Value("${mqtt.edge.default-topic}")
    private String defaultTopic;

    @RequestMapping("/sendMqtt.do")
    public String sendMqtt(@RequestBody MqttDTO dto) throws Exception {
        log.info("发送入口时间：" + new SimpleDateFormat(format).format(new Date()));
        log.info("打印入参dto = {}", dto);
        String str = JSON.toJSONString(dto);
        mqttGateway.sendToMqtt(str, defaultTopic);
        return "OK";
    }

    @RequestMapping("/acceptMqtt.do")
    public String acceptMqtt(@RequestBody MqttDTO dto, HttpServletRequest request) {
        return "OK";
    }

}

*/
