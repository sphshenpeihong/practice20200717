package com.sph.practice.component.boot.controller;

import com.google.common.collect.Lists;
import com.sph.practice.component.boot.resp.Response;
import com.sph.practice.mybatis.vo.ClassVO;
import com.sph.practice.mybatis.vo.ParamVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2021/4/14
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/response")
public class ResponseEntityCtl {

    @RequestMapping("/test1")
    public ResponseEntity<String> test1() {
        ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }

    @RequestMapping("/test2")
    public ResponseEntity<Response> test2() {
        ClassVO classVO = new ClassVO();
        classVO.setId(1);
        classVO.setClassName("123");
        return Response.ok(classVO);
    }




}
