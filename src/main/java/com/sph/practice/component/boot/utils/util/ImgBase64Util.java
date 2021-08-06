package com.sph.practice.component.boot.utils.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

/**
 * base64相关转换工具类
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@UtilityClass
@Slf4j
public class ImgBase64Util {

    /**
     * 图片（磁盘格式）转base64编码
     *
     * @param imgFile 图片磁盘全路径地址
     * @return base64编码
     */
    public static String imgToBase64(String imgFile) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
        } catch (IOException e) {
            log.error("图片读取出错", e.fillInStackTrace());
        } finally {
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("关闭输入流对象出错", e.fillInStackTrace());
                }
            }
        }
        return Base64.encodeBase64String(data);
    }

    /**
     * 图片（Http格式）转base64编码
     *
     * @param imgFile 图片地址（Http格式）
     * @return base64编码
     */
    public static String httpImgToBase64(String imgFile) {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        InputStream is = null;
        try {
            // 创建URL
            URL url = new URL(imgFile);
            byte[] by = new byte[2048];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            is = conn.getInputStream();
            // 将内容放到内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
        } catch (IOException e) {
            log.error("图片转换base64编码失败", e.fillInStackTrace());
        } finally {
            if (Objects.nonNull(is)) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("关闭输入流对象出错", e.fillInStackTrace());
                }
            }
        }
        // 对字节数组Base64编码
        return Base64.encodeBase64String(data.toByteArray());
    }

    /**
     * 将图片写入磁盘当中
     *
     * @param imgStr      图片数据（base64）
     * @param imgFilePath 图片存放地址
     */
    public static void base64ToImg(String imgStr, String imgFilePath) {
        //
        if (imgStr == null)// 图像数据为空
            return;
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpg图片
            out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();

        } catch (Exception e) {
            log.error("base64解析成图片过程当中出错", e.fillInStackTrace());
        } finally {
            if (Objects.nonNull(out)) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("关闭输出流对象出错", e.fillInStackTrace());
                }
            }
        }
    }

}
