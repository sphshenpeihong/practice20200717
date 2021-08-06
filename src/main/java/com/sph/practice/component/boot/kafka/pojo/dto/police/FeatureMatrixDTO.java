package com.sph.practice.component.boot.kafka.pojo.dto.police;

import lombok.Data;

/**
 * 布控人员特征值信息
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class FeatureMatrixDTO {

    /**
     * 算法厂家
     */
    private String manufacturer;

    /**
     * 算法人脸特征值
     */
    private String featureMatrix;

}
