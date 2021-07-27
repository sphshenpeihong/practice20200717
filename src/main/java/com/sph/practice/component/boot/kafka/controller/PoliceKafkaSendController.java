package com.sph.practice.component.boot.kafka.controller;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sph.practice.component.boot.kafka.constant.TopicConstant;
import com.sph.practice.component.boot.kafka.pojo.dto.capture.CheckMonitorStaffDTO;
import com.sph.practice.component.boot.kafka.pojo.dto.capture.FaceAlarmProto;
import com.sph.practice.component.boot.kafka.pojo.dto.capture.FaceImgProto;
import com.sph.practice.component.boot.kafka.test.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * "公安系统"推送数据到"广电系统"（使用kafka做数据交互）
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@RequestMapping("/kafka/police")
@RestController
@Slf4j
public class PoliceKafkaSendController {

    @Autowired
    private KafkaProducer kafkaProducer;

    /**
     * 路人抓拍图片
     *
     * @throws Exception
     */
    @RequestMapping("/passersByCapture")
    public void passersByCapture() throws Exception {
        // 封装对象
        FaceImgProto.KafkaFaceImgDto kafkaFaceImgDto
                = FaceImgProto.KafkaFaceImgDto.newBuilder()
                                              .setImgTime(System.currentTimeMillis())
                                              .setServerReceiveTime(System.currentTimeMillis())
                                              .setDataSource("kafka")
                                              .setDeviceId("10000004")
                                              .setImgMaxUrl("https://shenpeihong-1302432368.cos.ap-guangzhou.myqcloud.com/pic1/20210726110021.png")
                                              .setImgMinUrl("https://shenpeihong-1302432368.cos.ap-guangzhou.myqcloud.com/pic1/20210726110021.png")
                                              .setManufacturer("bingo")
                                              .build();
        // 序列化成字节数组
        byte[] bytes = kafkaFaceImgDto.toByteArray();

        kafkaProducer.send(TopicConstant.TOPIC_PassersByCapture, bytes);
    }

    /**
     * 新增布控人员
     */
    @RequestMapping("/addMonitorStaff")
    public void addMonitorStaff() throws Exception {
        FaceAlarmProto.KafkaKeyPersonCorrelationDto dto
                = FaceAlarmProto.KafkaKeyPersonCorrelationDto.newBuilder()
                                                             .setEmpId(System.currentTimeMillis())
                                                             .setCorrelationId(Long.valueOf(RandomUtil.randomNumbers(8)))
                                                             .setCorrelationType(2)
                                                             .setCorrelationContent("https://shenpeihong-1302432368.cos.ap-guangzhou.myqcloud.com/pic1/20210726143905.png")
                                                             .setSendTime(System.currentTimeMillis())
                                                             .build();

        byte[] bytes = dto.toByteArray();
        kafkaProducer.send(TopicConstant.SIBAT_KEY_PERSON_CORRELATION, bytes);

    }

    /**
     * 删除布控人员
     */
    @RequestMapping("/delMonitorStaff")
    public void delMonitorStaff() throws Exception {
        FaceAlarmProto.KafkaKeyPersonCorrelationDto dto
                = FaceAlarmProto.KafkaKeyPersonCorrelationDto.newBuilder()
                                                             .setEmpId(System.currentTimeMillis())
                                                             .setCorrelationId(Long.valueOf(RandomUtil.randomNumbers(8)))
                                                             .setCorrelationType(2)
                                                             .setCorrelationContent("https://shenpeihong-1302432368.cos.ap-guangzhou.myqcloud.com/pic1/20210726143905.png")
                                                             .setSendTime(System.currentTimeMillis())
                                                             .build();
        byte[] bytes = dto.toByteArray();
        kafkaProducer.send(TopicConstant.SIBAT_KEY_PERSON_CORRELATION_DELETE, bytes);
    }

    /**
     * 同步布控人员
     */
    @RequestMapping("/syncMonitorStaff")
    public void syncMonitorStaff() throws Exception {
        FaceAlarmProto.KafkaKeyPersonCorrelationDto dto
                = FaceAlarmProto.KafkaKeyPersonCorrelationDto.newBuilder()
                                                             .setEmpId(System.currentTimeMillis())
                                                             .setCorrelationId(Long.valueOf(RandomUtil.randomNumbers(8)))
                                                             .setCorrelationType(2)
                                                             .setCorrelationContent("https://shenpeihong-1302432368.cos.ap-guangzhou.myqcloud.com/pic1/20210726143905.png")
                                                             .setSendTime(System.currentTimeMillis())
                                                             .build();
        byte[] bytes = dto.toByteArray();
        kafkaProducer.send(TopicConstant.SIBAT_GRG_KEY_PERSON_CORRELATION_ALL, bytes);
    }

    /**
     * 对账差异人员
     */
    @RequestMapping("/checkMonitorStaff")
    public void checkMonitorStaff() throws Exception {
        // 封装入参对象
        CheckMonitorStaffDTO staffDTO = new CheckMonitorStaffDTO();
        staffDTO.setCorrelationId(76718750L);
        staffDTO.setManufacturers(Lists.newArrayList(2));
        byte[] bytes = JSON.toJSONBytes(staffDTO);
        kafkaProducer.send(TopicConstant.SIBAT_KEY_PERSON_CORRELATION_GRG_SYN, bytes);
    }

}
