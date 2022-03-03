package com.sph.practice.component.boot.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 测试Spring Security相关注解
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@RequestMapping("/security")
@RestController
public class SecurityCtl {

    // 当前用户需要具有ROLE_sale这个角色才可以访问该接口
    @Secured({"ROLE_sale11"})
    @RequestMapping("/test1")
    public String test1() {
        return "security test1";
    }

    // 当前用户需要具有hello该权限才可以访问该接口
    @PreAuthorize("hasAnyAuthority('hello')")
    @RequestMapping("/test2")
    public String test2(HttpServletResponse response) {
        response.setHeader("Authorization", "123asaxasa");
        return "security test2";
    }

    // 退出成功后，调该接口
    @RequestMapping("/postLogout")
    public String postLogout() {
        return "退出成功！！！";
    }

}
