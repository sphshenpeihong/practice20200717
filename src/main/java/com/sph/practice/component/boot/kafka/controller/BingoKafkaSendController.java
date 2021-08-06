package com.sph.practice.component.boot.kafka.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sph.practice.component.boot.kafka.constant.TopicConstant;
import com.sph.practice.component.boot.kafka.pojo.dto.police.FeatureDTO;
import com.sph.practice.component.boot.kafka.pojo.dto.police.FeatureMatrixDTO;
import com.sph.practice.component.boot.kafka.test.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@RequestMapping("/kafka/bingo")
@RestController
@Slf4j
public class BingoKafkaSendController {

    @Autowired
    private KafkaProducer<String> kafkaProducer;

    /**
     * 新增布控人员
     */
    @RequestMapping("/addMonitorStaff")
    public void addMonitorStaff() throws Exception {
        String featureMaxtrix = "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";
        String sign = "bD6MSFCpXh3ZB032MqE2dLFibjGDy1/vHyNvH0jQ81nvKhTu9v1QLCjg7KMWcveaYp/GXp6URUua4rQiDRl7SiH3USgtxAUfWI+hjRAZ7jBVwJjvmPaZaE2X2QGmWS5XXX28nI5TgG7XxRGF+XUUUDcU22RWVCdq6kFJTOLsc/o=RggAbanknigMIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBANnzhTSHw+L/YIkm7JWxQvCBLJoVbCO55EV0jtFyXMOxS8kJ7iWRQKkMZ3bIyHaVrpI3S5FmUX6Zn/5iczBYw9gaIyyf1nlyQHhpVR+QpO7lpXfZiLvyb0FXPv/Pb2jRh3fE0/IaRngVYNsw5gk/cLl8SkL2XKaM1fwKGhj9qsn7AgMBAAECgYEAzhJ3NvTLHLzTfLpF5T9GCHpKPqHUrm7by2PqiVQ1K35eJoZyGikdVvj4dpJfH+hkt7D6jU6N7UK5yN8zBFpZSCGqwVLjb2qbuM59EGoSjCPQt1P/QhXubC9btTo3S00CZCqGj4Xs1Rec94JtytEqDbYB3dVfife6inLGAjIu9OkCQQD9ACK0+9GU8J3eIAQnP4lQLGmXQIkrlDx+y8OBFYrFm8d4m76NyADV42DDNEwsJQ8JFymNnEiaF9W1qHkbnmsHAkEA3IkCVWx1ZUQsL9rxz/tuOaZWyDXOH6HgpsqlAe5Ysn+gwpBIJ29rV/0oVR+yrUngoOLPnBDJZlcjNqixDmkIbQJBAOjlPA3QldB+Y0S7wjcDBPs5twXWEa99KOcr2c+1LebUjR3YeOR5TVOXmVZ4iPpGLv4WRVknmanH8SHlcX7cKPcCQQCs78OkuShWAN+lp0t4jPIiww3Kcmbw50ADi2VZ3k4vq2WlLP9n7TeACEVYe0LiIMzFXRbwizljx3EVq7MsWbEBAkEAorUlS5cpxRLUvpWWa6SR3KY5b296D+Kb2ZHFUZngIEShti4wlsD4Wy90GWNStkY4ctBRVp1NfrWYlTPNpT965w==";
        List<FeatureMatrixDTO> matrixDTOList = Lists.newArrayList();
        FeatureMatrixDTO matrixDTO = new FeatureMatrixDTO();
        matrixDTO.setManufacturer("2");
        matrixDTO.setFeatureMatrix(featureMaxtrix);
        matrixDTOList.add(matrixDTO);

        FeatureDTO featureDTO = new FeatureDTO();
        featureDTO.setCorrelationId(RandomUtil.randomNumbers(8));
        featureDTO.setFeatures(matrixDTOList);
        featureDTO.setSign(sign);

        kafkaProducer.send(TopicConstant.GZMETRO_GRG_ANJIAN_FEATURE_ADD, JSON.toJSONString(featureDTO));
    }

    /**
     * 删除布控人员
     */
    @RequestMapping("/delMonitorStaff")
    public void delMonitorStaff() throws Exception {
        FeatureDTO featureDTO = new FeatureDTO();
        featureDTO.setCorrelationId("77352675");

        kafkaProducer.send(TopicConstant.GZMETRO_GRG_ANJIAN_FEATURE_DEL, JSON.toJSONString(featureDTO));
    }

}
