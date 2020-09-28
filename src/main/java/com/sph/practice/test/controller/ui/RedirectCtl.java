package com.sph.practice.test.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shen Peihong on 2020/9/28 16:07
 * Description:
 *
 * @since 1.0.0
 */
@Controller
public class RedirectCtl {

    //帮助跳转
    @RequestMapping(path = "/redirect.do")
    public String test2(HttpServletResponse response) throws IOException {
        //String preUrl = request.getContextPath()+"/jsp/wap/tips/error.html";
        //response.sendRedirect("poiTest");
        return "poiTest123";
    }

}
