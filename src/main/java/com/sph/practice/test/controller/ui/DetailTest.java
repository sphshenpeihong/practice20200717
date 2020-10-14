package com.sph.practice.test.controller.ui;

import com.sph.practice.test.param.ResultVO;
import com.sph.practice.test.param.TeacherVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * Created by Shen Peihong on 2020/9/28 18:10
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping(path = "/test")
public class DetailTest {

    /**
     * 测试返回json格式，但是String字符串是重新编码，而不是采用utf-8的编码
     */
    @RequestMapping(path = "/test1.do")
    public ResultVO test1() throws UnsupportedEncodingException {
        String s = new String("测试一下".getBytes(), "UTF-8");
        ResultVO resultVO = new ResultVO();
        resultVO.setResult(s);
        return resultVO;
    }

    /**
     * 测试使用阿里的注解
     */
    @RequestMapping(path = "/test2.do")
    public void test2(TeacherVO teacherVO) {
        System.out.println(teacherVO);
    }

    /**
     *
     */
    @RequestMapping(path = "/test3.do")
    public void test3() {

    }

    /**
     *
     */
    @RequestMapping(path = "/test4.do")
    public void test4() {

    }

    /**
     *
     */
    @GetMapping(path = "/test5.do")
    public void test5() {

    }


}
