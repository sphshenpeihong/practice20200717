package com.sph.practice.component.boot.kafka.util;

import com.alibaba.fastjson.JSON;
import com.sph.practice.component.boot.kafka.pojo.dto.capture.PassersByCaptureDTO;
import lombok.experimental.UtilityClass;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@UtilityClass
public class KafkaUtil {

    /**
     * 对象 -> 输出流对象 -> 字节数组 (使用Java字节流对象的方式)
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static byte[] convertObjToBytes(Object obj) throws Exception {
        return JSON.toJSONBytes(obj);

/*        try(
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream sOut = new ObjectOutputStream(out);
        ){
            sOut.writeObject(obj);
            sOut.flush();
            byte[] bytes = out.toByteArray();
            return bytes;
        }*/
    }


    /**
     * 字节数组 -> DTO对象（使用google的protobuf的API）
     *
     * @param bytes 待转换字节数组
     * @return 转换后的对象
     */
    public Object convertBytesToObj(byte[] bytes) {


        return null;
    }

}
