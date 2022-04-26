package com.sph.practice.component.boot.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.sph.practice.component.boot.pojo.dto.PUTTempDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shen Peihong on 2021/2/27
 * Description:
 *
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/hello1")
public class HelloCtl1 {

    @Value("${huanhang}")
    private String huanhang;

    @Value("${huanhang.huang}")
    private String huanhang1;

    @RequestMapping("/test1.do")
    public String test1() {
        System.out.println(huanhang1);
        return huanhang1;
    }

    @RequestMapping("/test11.do")
    public String test11() {
        System.out.println(huanhang);
        return huanhang;
    }

    @RequestMapping("/test2.do")
    public String test2(Integer code) {
        System.out.println(code);
        return String.valueOf(code);
    }

    @GetMapping("/test3.do")
    public String test3(Integer code) {
        log.info(String.valueOf(code));
        return String.valueOf(code);
    }

    @PutMapping("/test4.do")
    public String test4(Integer code, String ja) {
        System.out.println(code);
        System.out.println(ja);
        return String.valueOf(code);
    }

    @GetMapping("/test5.do")
    public String test5(Integer code) {
        System.out.println(code);
        return String.valueOf(code);
    }

    @PutMapping("/test6.do")
    public String test6(@RequestBody PUTTempDTO dto) {
        System.out.println(dto);
        return JSON.toJSONString(dto);
    }

    @GetMapping("/test7.do")
    public String test7(@RequestBody PUTTempDTO dto) {
        System.out.println(dto);
        return JSON.toJSONString(dto);
    }

    @DeleteMapping("/test8.do")
    public String test8(@RequestBody PUTTempDTO dto) {
        System.out.println(dto);
        return JSON.toJSONString(dto);
    }

    @GetMapping("/test9.do")
    public String test9(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "：" + cookie.getValue());
        }
        return "1";
    }

    @GetMapping("/test10.do")
    public String test10(HttpServletResponse response) {
        Cookie cookie = new Cookie("username", String.valueOf(System.currentTimeMillis()));
        response.addCookie(cookie);
        String s = HttpUtil.get("http://localhost:8086/shop/hello1/test3.do?code=5");
        System.out.println(s);
        return "1";
    }


}
