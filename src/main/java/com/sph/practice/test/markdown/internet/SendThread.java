package com.sph.practice.test.markdown.internet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Shen Peihong on 2020/10/22 22:39
 * Description:发送端
 *
 * @since 1.0.0
 */
public class SendThread implements Runnable {
    @Override
    public void run() {
        Socket socket = null;
        OutputStream output = null;
        try {
            //地址指向接收端
            socket = new Socket("127.0.0.1", 7878);
            //数据传输需要创建流管道
            output = socket.getOutputStream();
            byte[] bytes = new String("数据Data").getBytes();
            output.write(bytes);
            output.flush();//刷新缓冲区
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (output != null){
                    output.close();
                }
                if (socket != null){
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
