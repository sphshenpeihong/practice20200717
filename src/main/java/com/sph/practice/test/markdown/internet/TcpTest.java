package com.sph.practice.test.markdown.internet;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/10/22 22:38
 * Description: 网络通信之Tcp请求
 *
 * @since 1.0.0
 */
public class TcpTest {

    /**
     * 测试发送端与接收端
     */
    @Test
    public void test1(){
        //线程start一次线程执行完毕后就没了。所以需要让该线程不要停下来
        new Thread(new AcceptThread()).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new SendThread()).start();
    }

}
