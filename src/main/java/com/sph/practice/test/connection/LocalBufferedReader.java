package com.sph.practice.test.connection;

import org.junit.Test;

import java.io.*;

/**
 * Created by Shen Peihong on 2020/5/31 19:52
 * Description: 文件输入输出
 *
 * @since 1.0.0
 */
public class LocalBufferedReader {

    @Test
    public void test1(){
        try {
            FileReader reader = new FileReader(new File("D:\\毕设excel\\bishe.txt"));
            BufferedReader bufferedReader = new BufferedReader(reader);//传入输入字符流 初始化BufferedReader对象
            while (bufferedReader.readLine()!=null){
                System.out.println(bufferedReader.readLine());//读取一行
            }
        } catch (FileNotFoundException e) {
            System.out.println("无此文件。");
        } catch (IOException e) {
            System.out.println("IO异常");
        }

    }

    @Test
    public void test2(){

    }

}
