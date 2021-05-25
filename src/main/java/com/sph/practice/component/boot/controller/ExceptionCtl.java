package com.sph.practice.component.boot.controller;

import com.sph.practice.component.boot.resp.Response;
import com.sph.practice.component.exception.BaseException;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller测试出现各种异常情况
 *
 * @author Shen Peihong
 * @version: 1.0
 * @date 2021/5/10
 */
@RequestMapping(value = "/exception")
@RestController
public class ExceptionCtl {

    private String s = null;

    @SneakyThrows
    @GetMapping("/test1")
    public ResponseEntity<Response> test1(Integer code) {
        if (code.equals(1)){
            //自定义异常
            throw new BaseException(10086, "id不能为空");
        } else if (code.equals(2)){
            // 空指针异常
            s.isEmpty();
        } else if (code.equals(3)){
            int i = 1 / 0;
        }

        return Response.ok();
    }

}
