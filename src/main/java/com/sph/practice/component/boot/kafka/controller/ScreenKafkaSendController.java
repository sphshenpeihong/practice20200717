package com.sph.practice.component.boot.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sph.practice.component.boot.kafka.pojo.dto.screen.ContrabandData;
import com.sph.practice.component.boot.kafka.pojo.dto.screen.ContrabandDataGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 广州塔大屏推送
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@RequestMapping("/kafka/screen")
@RestController
@Slf4j
public class ScreenKafkaSendController {

    // GZMETRO_GRG_POLICE_RESULT
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 违禁品数据处置结果
     *
     * @throws Exception
     */
    @RequestMapping("/contrabandDataResult")
    public void contrabandDataResult() throws Exception {
        ContrabandData data = new ContrabandData();
        data.setRelationId("192.168.246.30_1639692945_20211217");
        data.setAlarmId(3296948L);
        data.setHandleType("1");
        data.setHandleEmpCode("292231");
        data.setHandleEmpCode("刘芳");
        data.setHandleEmpType("2");
        data.setHandleTime(System.currentTimeMillis());
        data.setCarryName("刘一");
        data.setCarryName("445122199701023778");
        data.setCarrySex("1");
        data.setCarryPhone("123");
        data.setCarryAddress("1");
        data.setCarryWorkUnit("1");

        ContrabandDataGoods goods = new ContrabandDataGoods();
        goods.setGoodId(3296948L);
        data.setGoods(Lists.newArrayList(goods));
        kafkaTemplate.send("GZMETRO_GRG_POLICE_RESULT", JSON.toJSONString(data));
    }

    /**
     * 违禁品数据处置结果（大屏）
     *
     * @throws Exception
     */
    @RequestMapping("/contrabandDataResultScreen")
    public void contrabandDataResultScreen() throws Exception {


    }

}
