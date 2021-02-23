package com.sph.practice.component.boot.controller;

import com.sph.practice.component.boot.pojo.po.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Shen Peihong on 2021/2/23
 * Description: Controller测试类
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/car")
public class CarCtl {

    @Resource
    private Car car;

    @RequestMapping("/test1.do")
    public Car test1(){
        return car;
    }

}
