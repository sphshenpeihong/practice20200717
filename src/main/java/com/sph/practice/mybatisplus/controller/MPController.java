package com.sph.practice.mybatisplus.controller;

import com.sph.practice.mybatisplus.pojo.po.QyPlusUser;
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

    // 插入
    @RequestMapping("/test2.do")
    public void test2(String name) {
        QyPlusUser qyPlusUser = new QyPlusUser(name, 1, "123");
        plusUserService.save(qyPlusUser);
    }

    // 更新
    @RequestMapping("/test3.do")
    public void test3(String name) {
        QyPlusUser qyPlusUser = new QyPlusUser(name, 1, "123");
        qyPlusUser.setId(5l);
        plusUserService.updateById(qyPlusUser);
    }

}
