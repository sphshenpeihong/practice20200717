package com.sph.practice.mybatisplus.pojo.dto;

import lombok.Data;

/**
 * 处理漏包数据入参DTO
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class LeakagePackageDTO {

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

}
