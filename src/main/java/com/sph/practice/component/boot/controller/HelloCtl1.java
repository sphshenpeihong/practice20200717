package com.sph.practice.component.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2021/2/27
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/hello1")
public class HelloCtl1 {

    @Value("${huanhang}")
    private String huanhang;

    @RequestMapping("/test1.do")
    public String test1(){
        System.out.println(huanhang);
        return huanhang;
    }

    @RequestMapping("/test11.do")
    public String test11(){
        System.out.println(huanhang);
        return huanhang;
    }

}
