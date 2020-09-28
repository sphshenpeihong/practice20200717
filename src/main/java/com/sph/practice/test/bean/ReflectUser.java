package com.sph.practice.test.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Shen Peihong on 2020/9/8 14:26
 * Description:
 *
 * @since 1.0.0
 */
public class ReflectUser<T> {

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    String startTime;
    //定义一个静态方法
    public static void test1(){}


}
