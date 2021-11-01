package com.sph.practice.test.controller.test.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class SubTest1VO {

    private String deviceId;

    private Integer total;

    private List<Long> eventIdList;

}
