package com.sph.practice.test.connection;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Created by Shen Peihong on 2020/5/31 1:36
 * Description:HttpUrlConnection类
 *
 * @since 1.0.0
 */
public class ConnectionTest {

    /**
     * 学习HttpUrlConnection类 JDK1.8提供的
     */
    @Test
    public void test1(){
        String baiduUrl = "http://www.baidu.com"; //调接口的路径
        try {
            URL url = new URL(baiduUrl); //创建url实例
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();//打开连接，创建HttpURLConnection连接对象
            connection.setRequestMethod("POST");//设置请求方式 POST请求
            connection.setDoOutput(true);//设置这个则http正文可以写请求参数 get请求就不需要，因为请求参数是直接拼接在URL后面的
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");//设置请求头参数
            connection.setUseCaches(false);//POST请求不使用缓存
            connection.setRequestProperty("Cookie", "SESSION=b1cb39e3-e0a8-4b6e-8a5d-1fe802e3ae61; sessionToken=68d18f83a7bf454db43dd194f37c0f83");
            DataOutputStream out = new DataOutputStream(connection
                    .getOutputStream());//直接将connection的输出流对象赋值，从而实现引用类型赋值，所以操作使用out对象写入数据，也能影响到connection的输出流对象
            out.writeBytes("&examId=3a5179e77fa147bb9cd452da4805c263");//写入需要转换成byte类型
            out.flush();//写完后，刷新输出流对象缓冲区，保持干净
            out.close();//写完关闭输出流对象
            //连接
            connection.connect(); //开始连接

            //得到响应码
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                //得到响应流
                InputStream inputStream = connection.getInputStream();
                //将响应流转换成字符串
                String result = new BufferedReader(new InputStreamReader(inputStream))
                        .lines().collect(Collectors.joining(System.lineSeparator()));
                System.out.println(result);
            }
        } catch (Exception e) {
            //一般打印日常即可，因为@JSONOut 有抛异常对象给前端
            System.out.println("打印异常日志");
        }
    }

    @Test
    public void test000(){
    }


}
