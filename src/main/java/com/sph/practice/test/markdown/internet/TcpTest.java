package com.sph.practice.test.markdown.internet;

import org.junit.Test;
import org.yaml.snakeyaml.nodes.ScalarNode;

import java.util.Scanner;

/**
 * Created by Shen Peihong on 2020/10/22 22:38
 * Description: 网络通信之Tcp请求
 *
 * @since 1.0.0
 */
public class TcpTest {

    //实现一个网络编程的需求
    //个人聊天室，可以达到双向通信聊天，将聊天内容打到控制台上
    //1、技术手段：利用TCP底层Socket类 + SocketServer
    //2、实现方法：程序执行一次就结束，所以必须使用循环，不让它停下来，实现双向通信，故需要使用多线程，让写和读线程同时启动。（线程内循环），即开启线程后不停下来

    /**
     * 测试发送端与接收端
     */
    @Test
    public void test1() throws InterruptedException {
        //线程start一次线程执行完毕后就没了。所以需要让该线程不要停下来
        new Thread(new AcceptThread()).start();
        Thread.sleep(1000);
        new Thread(new SendThread()).start();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//监听控制台输入
        while (true){
            String str = scanner.nextLine();//获取输入
            System.out.println(str);
        }
    }

}
