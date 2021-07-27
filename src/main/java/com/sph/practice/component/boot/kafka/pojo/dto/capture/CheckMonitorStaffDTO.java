package com.sph.practice.component.boot.kafka.pojo.dto.capture;

import lombok.Data;

import java.util.List;

/**
 * 对账差异人员
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class CheckMonitorStaffDTO {

    /**
     * 重点人员用户ID
     */
    private Long correlationId;

    /**
     * 算法厂家类型
     */
    private List<Object> manufacturers;

}
