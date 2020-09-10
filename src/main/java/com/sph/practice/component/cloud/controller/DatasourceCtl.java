package com.sph.practice.component.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2020/9/10 14:31
 * Description: 测试数据controller
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping(path = "/mgr/datasource")
public class DatasourceCtl {

    /**
     * 获取测试数据
     */
    @RequestMapping(path = "/getDatasource.do", produces = {"application/json;charset=UTF-8"})
    public void getDatasource(){
        System.out.println("111");
    }

}
