package com.sph.practice.component.boot.kafka.pojo.dto.police;

import lombok.Data;

import java.util.List;

/**
 * 布控人员信息
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class FeatureDTO {

    /**
     * 重点人员用户ID
     */
    private String correlationId;

    /**
     * 布控人员特征值信息列表
     */
    private List<FeatureMatrixDTO> features;

    /**
     * RSA算法签名
     */
    private String sign;

}
