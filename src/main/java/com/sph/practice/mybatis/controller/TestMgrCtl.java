package com.sph.practice.mybatis.controller;

import com.sph.practice.mybatis.pojo.QyTestPO;
import com.sph.practice.mybatis.service.ITestService;
import com.sph.practice.mybatis.service.IUserService;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shen Peihong on 2020/12/30 15:58
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/test/mgr")
public class TestMgrCtl {

    @Resource(name = "testService")
    private ITestService testService;

    @RequestMapping("/test1.do")
    public void test1(QyTestPO date11){
        System.out.println(date11);
        QyTestPO qyTestPO = testService.selectData();

        System.out.println(qyTestPO);
    }

    /**
     *
     */
    @Test
    public void test1(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        System.out.println(format);

    }
}
