package com.sph.practice.mybatis.controller;

import com.sph.practice.component.exception.BaseException;
import com.sph.practice.mybatis.pojo.QyTestPO;
import com.sph.practice.mybatis.service.ITestService;
import com.sph.practice.mybatis.service.IUserService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping(value = "/test/mgr")
public class TestMgrCtl {

    @Resource(name = "testService")
    private ITestService testService;

    //时间类型


    @RequestMapping("/test1.do")
    public void test1(QyTestPO date11){
        System.out.println(date11);
        QyTestPO qyTestPO = testService.selectData();

        System.out.println(qyTestPO);
    }

    //根据入参插入到数据库 看看，String类型能不能插入成功（mysql Date类型）

    @RequestMapping("/test2.do")
    public void test11(QyTestPO date11){
        testService.insertData();
    }

    @RequestMapping("/test3.do")
    public void test3(){
        // 这里去update数据库的数据  金额的 此时没加事务
        testService.handleAccount();
    }

    @RequestMapping("/test4.do")
    public void test4(){
        QyTestPO qyTestPO = new QyTestPO();
        qyTestPO.setDate1(new Date());
        int data = testService.createData(qyTestPO);
        System.out.println(data);
    }

    @RequestMapping("/test5.do")
    void test5(Integer code) throws Exception{
        if (Integer.valueOf(1).equals(code)) {
            throw new BaseException(6, "出错了");
        } else if(Integer.valueOf(2).equals(code)){
            throw new Exception("12321");
        }
        log.info("我试试看看test5");
        System.out.println("111");
    }



}
