package com.sph.practice.component.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shen Peihong on 2021/2/27
 * Description:
 *
 * @since 1.0.0
 */
// 不能使用@RestController，因为里面有@ResponseBody(会将返回值转json对象)
@Controller
public class WelComePageCtl {
    /**
     * SpringBoot有bug，配了静态资源访问前缀的话，访问项目根目录无法默认跳到index.html
     * 所以需要对访问根路径的请求由接口来进行请求重定向
     *
     * @return
     */
    @RequestMapping("/")
    public String welComePage() {
        //不用带.html后缀，因为我们在application.yml中配置前后缀了。
        return "/res/index";
    }
}