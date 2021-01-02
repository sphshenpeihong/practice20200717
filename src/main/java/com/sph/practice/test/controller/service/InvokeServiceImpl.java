package com.sph.practice.test.controller.service;

import org.springframework.stereotype.Service;

/**
 * Created by Shen Peihong on 2020/12/26 16:24
 * Description:
 *
 * @since 1.0.0
 */
@Service("invokeService")
public class InvokeServiceImpl {

    int i = 100;

    public void test1(){
        System.out.println(i);
        i = 666;
    }

    public void test2(){
        System.out.println(i);
    }

}
