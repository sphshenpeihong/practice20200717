package com.sph.practice.test.markdown.designPattern.adapter;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/11/27 1:25
 * Description:手机类，因为它需要使用适配类提供的方法，进行充电操作
 *
 * @since 1.0.0
 */
public class Phone {

    /**
     * 封装手机进行充电的方法
     */
    public void charging(IU5V iu5V){
        //这里需要用到适配器类提供的方法，我们不要直接New对象，而是采用方法形参的方式，
        //类实现接口，利用了多态后，可扩展性强
        Integer u = iu5V.Translate220VTo5V();
        if (u == 5){
            System.out.println("找到对应的充电方法了，充电完成");
        }else{
            System.out.println("找不到对应的充电方法，充电失败");
        }
    }

}
