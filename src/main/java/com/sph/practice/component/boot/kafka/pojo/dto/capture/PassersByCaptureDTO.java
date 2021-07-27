package com.sph.practice.component.boot.kafka.pojo.dto.capture;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 人脸抓拍 公安 -> 广电 （公安内网）
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Data
public class PassersByCaptureDTO implements Serializable {
    private String dataSource;
    private String deviceId;
    private String manufacturer;
    private String imgMinUrl;
    private String imgMaxUrl;
    private Long imgTime;
    private Long serverReceiveTime;
}
