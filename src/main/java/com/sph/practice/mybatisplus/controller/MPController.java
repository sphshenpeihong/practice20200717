package com.sph.practice.mybatisplus.controller;

import com.sph.practice.mybatisplus.service.IPlusUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Shen Peihong on 2021/1/26
 * Description:
 *
 * @since 1.0.0
 */

@RestController
@RequestMapping("/plus/mgr")
public class MPController {

    @Resource(name = "plusUserService")
    private IPlusUserService plusUserService;

    @RequestMapping("/test1.do")
    public void test1() {
        plusUserService.mpTest();
    }

}
