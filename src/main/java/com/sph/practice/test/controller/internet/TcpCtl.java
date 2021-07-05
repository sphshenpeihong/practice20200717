package com.sph.practice.test.controller.internet;

import com.sph.practice.test.markdown.internet.AcceptThread;
import com.sph.practice.test.markdown.internet.SendThread;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shen Peihong on 2020/10/29 11:26
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/tcp")
public class TcpCtl {

    @RequestMapping("/test1.do")
    public void test1() throws InterruptedException {
        //线程start一次线程执行完毕后就没了。所以需要让该线程不要停下来
        new Thread(new AcceptThread()).start();
        Thread.sleep(2000);//防止发送线程先执行
        // new Thread(new SendThread()).start();

    }

    /**
     * 连接TCP
     */
    @Test
    public void test() throws InterruptedException {

    }

    /**
     *
     */
    @RequestMapping("/test2")
    public void test2() {
        Socket socket = null;
        OutputStream output = null;
        try {
            System.out.println("开始打印：");
            //地址指向接收端
            socket = new Socket("192.168.122.129", 7878);
            //数据传输需要创建流管道
            output = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);//获取控制台输入，敲回车则为一行
            String line = scanner.nextLine();//获取敲回车前的一行数据
            System.out.println("test2");
            byte[] bytes = new String(line).getBytes();
            output.write(bytes);
            output.flush();//刷新缓冲区
            System.out.println("test3");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}