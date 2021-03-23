package com.sph.practice.component.boot.controller;

import com.google.common.collect.Maps;
import com.sph.practice.component.boot.param.ParamJson;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shen Peihong on 2021/3/14
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/parameter")
public class ParameterCtl {

    // 定义一个非静态的，则看看情况，按道理这个ctl对象是单例的，那么定义放Map值 看看下次请求是不是同一个对象了
    private Map<String, Object> cacheMap = new HashMap<>();

    @RequestMapping("/test2.do")
    public void test2() {
        cacheMap.put("dage", "123");
    }

    /**
     * 试试用RestFul风格传参，并且不要使用?的方式去传参，而是直接斜杆/
     * 然后Controller方法使用占位符({})，然后使用@PathVariable动态映射到形参当中
     *
     * @return
     */
    @GetMapping("/test1.do/{id}/owner/{name}")
    public Map<String, Object> test1(@PathVariable("id") String id,
                                     @PathVariable("name") String name,
                                     @PathVariable Map<String, String> pv,
                                     // 获取请求头部信息
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String, String> headers,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("sex") Integer sex,
                                     @RequestParam Map<String, String> paramMaps,
                                     @CookieValue("sessionToken") String sessionToken,
                                     @CookieValue("token") Cookie cookie){


        // 接收到前端的参数后，封装到Map当中，然后返回给前端
        // 后端无论返回什么类型，都会转成JSON的形式返回给前端的
        // 因为使用了@ResponseBody注解
        Map<String, Object> respMap = new HashMap<>();
       /*
        respMap.put("id", id);
        respMap.put("name", name);
        respMap.put("pv", pv);
        respMap.put("userAgent", userAgent);
        respMap.put("headers", headers);
        */
        respMap.put("age", age);
        respMap.put("sex", sex);
        respMap.put("paramMaps", paramMaps);
        respMap.put("sessionToken", sessionToken);
        respMap.put("cookie", cookie);
        return respMap;
    }

    // 若前端传递参数的类型是json格式的话，那么只有使用@RequestBody 将json类型转java 这才能成功地接收
    @PostMapping("/save")
    public Map<String, Object> test2(@RequestBody ParamJson content){
        HashMap<String, Object> respMap = Maps.newHashMap();
        /*
        respMap.put("token", token);
        respMap.put("sex", sex);
        */
        respMap.put("content", content);
        return respMap;
    }
}
