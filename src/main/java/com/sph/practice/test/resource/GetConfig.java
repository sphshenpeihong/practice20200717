package com.sph.practice.test.resource;

import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Shen Peihong on 2020/12/12 22:03
 * Description:
 *
 * @since 1.0.0
 */
@RestController
public class GetConfig {

    @RequestMapping("/config.do")
    public void test1(){
        Properties properties = new Properties();
        InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream("local/local.properties");
            properties.load(is);
            String username = properties.getProperty("username");
            System.out.println(username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取同级目录下的properties 看看可不可以拿得到
    /**
     *
     */
    @Test
    public void test(){

    }


}
