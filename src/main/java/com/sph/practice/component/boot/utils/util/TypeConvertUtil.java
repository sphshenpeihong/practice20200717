package com.sph.practice.component.boot.utils.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.io.*;
import java.util.Objects;

/**
 * 类型转换工具类
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@UtilityClass
@Slf4j
public class TypeConvertUtil {

    /**
     * Java对象转换成字节数组
     *
     * @param obj Java对象
     * @return 字节数组对象
     * @author Shen Peihong
     */
    public byte[] objToBytes(@NonNull Object obj) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        byte[] bytes = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.flush();
            bytes = baos.toByteArray();
        } catch (IOException e) {
            log.error("进行类型转换过程中出错，e = {}", e.getMessage());
        } finally {
            try {
                if (Objects.nonNull(oos)) {
                    oos.close();
                }
                if (Objects.nonNull(baos)) {
                    baos.close();
                }
            } catch (IOException e) {
                log.error("关闭输出流对象过程中出错，e = {}", e.getMessage());
            }
        }
        return bytes;
    }

    /**
     * 字节数组转换成Java对象
     *
     * @param bytes 字节数组
     * @return Java对象
     * @author Shen Peihong
     */
    @SuppressWarnings("unchecked")
    public <T> T bytesToObj(@NonNull byte[] bytes, @NonNull Class<T> clazz) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        T obj = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            obj = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error("进行类型转换过程中出错，e = {}", e.getMessage());
        } finally {
            try {
                if (Objects.nonNull(ois)) {
                    ois.close();
                }
                if (Objects.nonNull(bais)) {
                    bais.close();
                }
            } catch (IOException e) {
                log.error("关闭输入流对象过程中出错，e = {}", e.getMessage());
            }
        }
        return obj;
    }
}
