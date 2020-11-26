package com.sph.practice.test.markdown.designPattern.adapter;

/**
 * Created by Shen Peihong on 2020/11/27 1:20
 * Description: 被适配的类
 *
 * @since 1.0.0
 */
public class U220V {

    public Integer u220V(){
        int u = 220;
        System.out.println("当前电压为：" + u + "V");
        return u;
    }

}
