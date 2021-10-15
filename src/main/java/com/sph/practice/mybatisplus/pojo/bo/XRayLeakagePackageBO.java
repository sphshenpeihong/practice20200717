package com.sph.practice.mybatisplus.pojo.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Data
public class XRayLeakagePackageBO implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 事件ID
     */
    private String eventId;

    /**
     * 主视角图片（Http地址）
     */
    private String picture;

    /**
     * 包裹上传时间
     */
    private String sendMsgTime;

}
