package com.sph.practice.test.serialization;

import com.sph.practice.test.serialization.dto.bit.ByteDTO;
import com.sph.practice.test.serialization.dto.bit.ByteRefDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * Java对象与二进制流 （序列化/反序列化）
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Slf4j
public class ByteSerialization {

    /**
     * Java对象序列化成二进制流
     *
     * @throws Exception
     */
    @Test
    public void byteWrite() throws Exception {
        // 封装对象
        ByteDTO byteDTO = new ByteDTO();
        byteDTO.setId(1);
        byteDTO.setUsername("张三");
        byteDTO.setPassword("456");
        byteDTO.setSex(2);

        // 引用对象赋值
        ByteRefDTO refDTO = new ByteRefDTO();
        refDTO.setRef("ref");
        byteDTO.setRefDTO(refDTO);

        // 父类属性赋值
        byteDTO.setParent("parent");

        // 文件输出流对象（需要指向具体某个文件的地址）
        FileOutputStream fos = new FileOutputStream("D:\\temp\\IO流练习demo\\serialization\\byteWrite.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(byteDTO);
    }

    /**
     * 二进制流反序列化成Java对象
     *
     * @throws Exception
     */
    @Test
    public void byteRead() throws Exception {
        FileInputStream fis = new FileInputStream("D:\\temp\\IO流练习demo\\serialization\\byteWrite.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ByteDTO byteDTO = (ByteDTO) ois.readObject();
        System.out.println(byteDTO);
        System.out.println(byteDTO.getParent());
    }

}
