package com.sph.practice.component.boot.controller;

import com.sph.practice.component.boot.service.NullService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sphong
 * @version: 1.0
 * @date 2021/4/15
 * @since V1.0.0.2
 */
@RestController
@RequestMapping("/null2")
public class NullController {

    @Resource
    private NullService nullService;

    @RequestMapping("/test1")
    public void test1() {
        Object o = new Object();
        String s = nullService.null1(null, o);
        System.out.println(s);
    }

}
