package com.sph.practice.test.controller.ui;

import com.sph.practice.test.param.BankVO;
import com.sph.practice.test.param.StudentVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.sql.SQLType;

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

    //@ApiParam
    //以下详细测试注解的属性使用 ------ end

    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "username", value = "登陆账号", required = true, dataType = "String", example = "zhangfei", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "登陆密码", required = true, dataType = "String", example = "mima123456" ,paramType = "query")
    })
    @GetMapping("/test6.do")
    public StudentVO test6(@RequestParam(name = "username")String username,
                           @RequestParam(name = "password")String password){
        StudentVO studentVO = new StudentVO();
        studentVO.setAge("1");
        studentVO.setId("4354");
        studentVO.setName("5454");
        return new StudentVO();

    }

    @MyAnnotation(value = "123", list = {"132","456"})
    private void test7(){

    }



}

@Target({ElementType.TYPE,ElementType.METHOD})
@interface MyAnnotation{
    //别名
    @AliasFor("name")
    String value();

    @AliasFor("value")
    String name() default "12323";//添加默认值，不然使用时必须指定

    String[] list() default {"123","456"};
}

//reset1
