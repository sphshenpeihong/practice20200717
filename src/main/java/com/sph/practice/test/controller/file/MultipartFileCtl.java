package com.sph.practice.test.controller.file;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.util.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Shen Peihong on 2020/10/24 1:04
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/file")
public class MultipartFileCtl {

    /**
     * 使用MultipartFile文件上传工具类的接口
     * @param file
     */
    @RequestMapping("/test1.do")
    public void test1(MultipartFile file) {
        FileOutputStream fos = null;
        try {
            //获得文件大小，单位是字节 ：  7126
            System.out.println("file.getSize()" + "：" + file.getSize());
            //获得文件原名(带后缀) ：  hrmanagement.html
            System.out.println("file.getOriginalFilename()" + "：" + file.getOriginalFilename());
            //获得文件的字节数组
            System.out.println("file.getBytes()" + "：" + file.getBytes());
            //获得请求头类型 ： text/html
            System.out.println("file.getContentType()" + "：" + file.getContentType());
            //获得文件输入流
            System.out.println("file.getInputStream()" + "：" + file.getInputStream());
            //文件上传的第二种方式，获取字节数组，然后自己通过IO流自己输出
            fos = new FileOutputStream("D:\\temp\\IO流练习demo\\" + file.getOriginalFilename());
            fos.write(file.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
