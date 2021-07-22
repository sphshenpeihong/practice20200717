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
    private Object dataSource;
    private Object deviceId;
    private Object manufacturer;
    private Object imgMinUrl;
    private Object imgMaxUrl;
    private Long imgTime;
    private Long serverReceiveTime;


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(this.dataSource);
        out.writeObject(this.deviceId);
        out.writeObject(this.manufacturer);
        out.writeObject(this.imgMinUrl);
        out.writeObject(this.imgMaxUrl);
        out.writeObject(this.imgTime);
        out.writeObject(this.serverReceiveTime);
        byte[] bytes = JSON.toJSONBytes(this);
    }


    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.dataSource = in.readObject();
        this.deviceId = in.readObject();
        this.manufacturer = in.readObject();
        this.imgMinUrl = in.readObject();
        this.imgMaxUrl = in.readObject();
        this.imgTime = (Long) in.readObject();
        this.serverReceiveTime = (Long) in.readObject();
    }
}
