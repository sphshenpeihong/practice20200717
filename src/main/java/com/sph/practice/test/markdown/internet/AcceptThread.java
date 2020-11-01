package com.sph.practice.test.markdown.internet;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Shen Peihong on 2020/10/22 22:39
 * Description:接收端
 *
 * @since 1.0.0
 */
public class AcceptThread implements Runnable {
    @Override
    public void run() {
        ServerSocket ss = null;
        Socket accept = null;
        InputStream input = null;
        try {
            ss = new ServerSocket(7878);
            //由于是TCP传输，所以需要建立与发送端的连接，执行到这里时，接收端此时会一直等待发送端的连接
            accept = ss.accept();
            while (true){
                //传输数据格式是IO流，所以获取输入流接收数据
                input = accept.getInputStream();
                //定义字节数组接收
                byte[] buf = new byte[1024];
                int length = input.read(buf);
                String str = new String(buf, 0, length);
                System.out.println("接收端已接收到数据 = " + accept.getInetAddress() + ":" + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //先打开后释放
                if (input != null) {
                    input.close();
                }
                if (accept != null){
                    accept.close();
                }
                if (ss != null){
                    ss.close();
                }
            } catch (Exception e) {
                System.out.println("关闭连接对象出错");
            }

        }
    }
}
