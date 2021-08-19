
package com.sph.practice.component.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2021/5/7
 */

@Controller
public class SocketController {

    //@Autowired
    //private WebsocketServer webSocketServer;

    @RequestMapping("/index111")
    public String index() {
        return "index";
    }

    @GetMapping("/webSocket")
    public ModelAndView socket() {
        ModelAndView mav=new ModelAndView("/webSocket");
//        mav.addObject("userId", userId);
        return mav;
    }

}

