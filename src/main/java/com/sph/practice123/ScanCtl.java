package com.sph.practice123;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2021/2/22
 * Description:
 *
 * @since 1.0.0
 */
@RestController
public class ScanCtl {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/test1.do")
    public String test1(){
        return "Hello,World!" + "：" + serverPort;
    }

}
