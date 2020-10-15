package com.sph.practice.test.controller.ui;

import com.sph.practice.test.param.BankVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2020/10/15 12:29
 * Description:相关Swagger测试用例
 *
 * @since 1.0.0
 */

@RestController
@RequestMapping("/swagger")
public class SwaggerCtl {
    /*
        测试用例汇总：Get请求和POST请求两大列

     */


    @GetMapping("/test1.do")
    @ApiOperation("Swagger接口类")
    public BankVO test1(@ApiParam("用户名") String username,@ApiParam("密码") String password,String desc){
        return new BankVO();
    }

    @ApiOperation("Get请求，测试最简单的请求")
    @GetMapping("/test2.do")
    public BankVO test2(){
        return new BankVO();
    }

    @ApiOperation("Get请求，无请求参数，返回VO对象")
    @GetMapping("/test3.do")
    public BankVO test3(@ApiParam("用户名")String username){
        BankVO bankVO = new BankVO();
        bankVO.setId("1");
        bankVO.setCardNumber("232");
        bankVO.setPersonName("4343");
        return bankVO;
    }

    @ApiOperation("Get请求，无请求参数，返回VO对象")
    @GetMapping("/test4.do")
    public BankVO test4(String username){
        BankVO bankVO = new BankVO();
        bankVO.setId("1");
        bankVO.setCardNumber("232");
        bankVO.setPersonName("4343");
        return bankVO;
    }

    @ApiOperation("Post请求，无请求参数，返回VO对象")
    @PostMapping("/test5.do")
    public BankVO test5(@ApiParam("方法形参") String username){
        BankVO bankVO = new BankVO();
        bankVO.setId("1");
        bankVO.setCardNumber("232");
        bankVO.setPersonName("4343");
        return bankVO;
    }

}
