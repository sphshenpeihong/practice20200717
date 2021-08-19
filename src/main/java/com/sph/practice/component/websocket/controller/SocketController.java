
package com.sph.practice.component.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Websocket
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2021/5/7
 */
@Controller
public class SocketController {

    /**
     * 跳转到websocket页面（因为template动态页面直接访问是访问不了的，得利用后端重定向）
     *
     * @return
     */
    @GetMapping("/webSocket")
    public ModelAndView socket() {
        ModelAndView mav = new ModelAndView("/webSocket");
        //mav.addObject("userId", userId);
        return mav;
    }

}

