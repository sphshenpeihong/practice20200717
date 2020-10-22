package com.sph.practice.test.controller.session;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by Shen Peihong on 2020/10/21 22:53
 * Description: session
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/session")
public class SessionCtl {

    /**
     *
     */
    @RequestMapping("/test1.do")
    public void test1(HttpSession session) throws InterruptedException {
        //设置session属性
        session.setAttribute("wxqyhUserId", UUID.randomUUID().toString().replaceAll("-", ""));
        //设置session过期时间
        session.setMaxInactiveInterval(1);
        //获取session属性
        String wxqyhUserId = (String) session.getAttribute("wxqyhUserId");
        System.out.println(wxqyhUserId);
        /*
            737fb3e4961646d3a7bc406340e84e97
         */
        //删除某个session的key/value键值对
        session.removeAttribute("wxqyhUserId");

    }

    /**
     *
     */
    @RequestMapping("/test2.do")
    public void test2(){

    }

    /**
     *
     */
    @RequestMapping("/test3.do")
    public void test3(){

    }



}
