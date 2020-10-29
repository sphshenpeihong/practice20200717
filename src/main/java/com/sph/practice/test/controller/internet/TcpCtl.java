package com.sph.practice.test.controller.internet;

import com.sph.practice.test.markdown.internet.AcceptThread;
import com.sph.practice.test.markdown.internet.SendThread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Thread.sleep(500);//防止发送线程先执行
        new Thread(new SendThread()).start();
    }

}
