package com.sph.practice.test.markdown.internet;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Shen Peihong on 2020/10/22 22:28
 * Description:
 *
 * @since 1.0.0
 */
public class InternetTest {

    /**
     *
     */
    @Test
    public void test1() throws UnknownHostException {
        //也可以根据主机名(计算机名)构建InetAddress对象
        InetAddress ip = InetAddress.getByName("LAPTOP-OSAFAJBF");
        //也可以根据ip地址(字符串)构建InetAddress对象
        InetAddress ip1 = InetAddress.getByName("192.168.11.125");
    }



}
