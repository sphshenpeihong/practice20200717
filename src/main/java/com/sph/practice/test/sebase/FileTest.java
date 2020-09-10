package com.sph.practice.test.sebase;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Shen Peihong on 2020/7/15 17:47
 * Description:
 *
 * @since 1.0.0
 */
public class FileTest {

    /**
     * File.createTempFile()  生成临时文件 自己指定前后缀  默认保存在本地的C盘呢
     */
    @Test
    public void test1() throws IOException {
        File tempFile = File.createTempFile("abc", ".xls");  //新建一个临时文件，默认是本地的C盘
        File dir = new File("D:\\沈培泓临时D盘了");
        File tempFile1 = File.createTempFile("abc", ".xls", dir);  //新建一个临时文件，默认是本地的C盘
        System.out.println(tempFile);
        System.out.println(tempFile.getPath());
        /*if (tempFile.exists()){ //该对象已指向文件，可以对文件进行各种操作
            tempFile.delete();
        }*/
    }

    /**
     * 创建一个文件对象，指向本地的某个文件，然后判断是否存在，存在的话直接删除了
     */
    @Test
    public void test2(){
        File file = new File("C:\\Users\\93924\\AppData\\Local\\Temp\\8f2ada2e-3275-4d3d-ba62-01d1b579721c.png");
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        if (file.exists()){
            file.delete();
        }
    }

    /**
     * 本地新建指向文件夹
     */
    @Test
    public void test3() throws IOException {
        File file = new File("D:\\111"); //普通的File不会自己去新建，但是POI的那些就会
    }

}
