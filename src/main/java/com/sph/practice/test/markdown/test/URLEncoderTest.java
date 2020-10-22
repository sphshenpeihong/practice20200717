package com.sph.practice.test.markdown.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Shen Peihong on 2020/10/20 15:09
 * Description:
 *
 * @since 1.0.0
 */
public class URLEncoderTest {

    /**
     * URLEncoder.encode(String msg,String encode)： URL如果含有中文或特殊符号的话，需要使用编码方法对中文以及符号( : / ?)进行加密转码
     */
    @Test
    public void test() throws UnsupportedEncodingException {
        String html = "https://www.baidu.com/error.html?msg=大哥你牛";
        String encode = URLEncoder.encode(html, "UTF-8");
        System.out.println(encode);//URL如果含有中文或特殊符号( : / ?)的话，需要使用编码方法加密转码
        /*
            https%3A%2F%2Fwww.baidu.com%2Ferror.html%3Fmsg%3D%E5%A4%A7%E5%93%A5%E4%BD%A0%E7%89%9B
         */
    }

    /**
     * URLDecoder.decode();//URL解密
     */
    @Test
    public void test1() throws UnsupportedEncodingException {
        String encode = "https%3A%2F%2Fwww.baidu.com%2Ferror.html%3Fmsg%3D%E5%A4%A7%E5%93%A5%E4%BD%A0%E7%89%9B";
        String decode = URLDecoder.decode(encode, "UTF-8");//URL加解密所用字符编码格式需要使用同一个
        System.out.println(decode);
        /*
            https://www.baidu.com/error.html?msg=大哥你牛
         */
    }

}
