package com.sph.practice.component.boot.kafka.controller;

import com.sph.practice.component.boot.kafka.pojo.dto.capture.PassersByCaptureDTO;
import com.sph.practice.component.boot.kafka.test.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */

@RequestMapping("/kafka")
@RestController
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/send")
    public void sendMsg() throws Exception {
        PassersByCaptureDTO dto = new PassersByCaptureDTO();
        dto.setImgTime(System.currentTimeMillis());
        dto.setServerReceiveTime(System.currentTimeMillis());
        dto.setDataSource("dataSource");
        dto.setDeviceId("deviceId");
        dto.setImgMaxUrl("imgMaxUrl");
        dto.setImgMinUrl("imgMinUrl");
        kafkaProducer.send(dto);
    }










/*    @RequestMapping("/send")
    public void sendMsg() {
        kafkaProducer.send("this is a controller kafka topic message!");
    }*/

}