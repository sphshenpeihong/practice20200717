package com.sph.practice.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2020/9/13 16:36
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test/son")
public class SonCtl extends ParentCtl{

    @RequestMapping(path = "/son.do")
    public void getPrint(){
        System.out.println("SonCtl ..");
    }

}
