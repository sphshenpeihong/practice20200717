package com.sph.practice.component.boot.test;

import com.sph.practice.component.boot.kafka.pojo.dto.capture.PassersByCaptureDTO;
import com.sph.practice.component.boot.utils.util.TypeConvertUtil;
import org.junit.Test;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
public class BootTest {

    /**
     * 单元测试
     */
    @Test
    public void test1() {
        // 封装dto对象
        PassersByCaptureDTO dto = new PassersByCaptureDTO();
        dto.setImgTime(System.currentTimeMillis());
        dto.setDataSource("123");
        dto.setDeviceId("设备ID哦");

        // dto对象转换成字节数组对象
        byte[] bytes = TypeConvertUtil.objToBytes(dto);
        System.out.println(bytes);

        // 字节数组对象转换成dto对象
        PassersByCaptureDTO respDTO = TypeConvertUtil.bytesToObj(bytes, PassersByCaptureDTO.class);
        System.out.println(respDTO);

    }


}
