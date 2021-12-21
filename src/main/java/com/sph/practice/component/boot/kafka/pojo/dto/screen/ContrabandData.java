package com.sph.practice.component.boot.kafka.pojo.dto.screen;

import lombok.Data;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class ContrabandData {

    private String relationId;

    private Long alarmId;

    private String handleType;

    private String handleEmpCode;

    private String handleEmpName;

    private String handleEmpType;

    private Long handleTime;

    private String carryName;

    private String carryIdCard;

    private String carrySex;

    private String carryPhone;

    private String carryAddress;

    private String carryWorkUnit;

    private List<ContrabandDataGoods> goods;


}
