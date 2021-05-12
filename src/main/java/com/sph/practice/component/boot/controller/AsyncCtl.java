package com.sph.practice.component.boot.controller;

import com.sph.practice.component.boot.service.AsyncService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/5/12
 */
@RestController
@RequestMapping("/async")
public class AsyncCtl {

    @Resource
    private AsyncService asyncService;

    @RequestMapping("/test1")
    public void test1() throws InterruptedException {
        asyncService.async();
        System.out.println("主线程，应该不会被阻塞吧？");
    }

}
