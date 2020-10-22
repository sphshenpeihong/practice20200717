package com.sph.practice.test.markdown.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Shen Peihong on 2020/10/20 15:27
 * Description:Properties类对象映射.properties配置文件
 *
 * @since 1.0.0
 */
@Component
public class PropertiesTest {


    /**
     * 使用Properties类去接收.properties配置文件的值
     */
    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("jdbc/jdbc.properties");//获取指向classes目录
        properties.load(is);//指向输入流地址
        String url = properties.getProperty("url");
        System.out.println(url);
        /*
            urlTest
         */
    }

    /**
     * 使用Document类去接收.xml配置文件的值
     */
    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("jdbc/jdbc.xml");//获取指向classes目录
        properties.loadFromXML(is);//指向输入流地址
        String url = properties.getProperty("url");
        System.out.println(url);
    }

}
