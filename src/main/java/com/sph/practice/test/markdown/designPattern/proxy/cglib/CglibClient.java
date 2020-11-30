package com.sph.practice.test.markdown.designPattern.proxy.cglib;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/11/29 18:05
 * Description: 客户类
 *
 * @since 1.0.0
 */
public class CglibClient {

    /**
     *
     */
    @Test
    public void test(){
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        CglibProxyUtil<TeacherServiceImpl> cglibProxy = new CglibProxyUtil<>(teacherService);
        TeacherServiceImpl cglibProxyInstance = cglibProxy.getCglibProxyInstance();
        cglibProxyInstance.teach();

    }

}
