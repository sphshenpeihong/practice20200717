package com.sph.practice.test.spring.controller;

import com.sph.practice.mybatis.util.ApplicationContextUtil;
import com.sph.practice.test.spring.bean.BeanService;
import com.sph.practice.test.spring.bean.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@RestController
@RequestMapping("/bean")
public class BeanTestCtl {

    @Resource(name = "beanConfig1")
    private BeanConfig beanConfig;

    // static变量，触发时机：类被加载器加载时成员变量
    // 成员变量，触发时机：类被用构造方法new的时候，构造方法里边可以对成员变量进行修改，如果不修改，则原来赋什么值就是什么值了
    ApplicationContext ac = ApplicationContextUtil.getContext();

    @RequestMapping("/test1")
    public Object test1() {
        Map<String, BeanService> beans = ac.getBeansOfType(BeanService.class);
        for (Map.Entry<String, BeanService> entry : beans.entrySet()) {
            System.out.println("==========下面开始打印bean==========");
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        return null;
    }

    @RequestMapping("/test2")
    public Object test2() {
        for (int i = 0; i < 5; i++) {
            beanConfig.useBean(String.valueOf(i));
        }
        return null;
    }


}
