package com.sph.practice.test.sebase.abstractClass;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shen Peihong on 2020/11/26 14:45
 * Description: 定义方法，然后到时候子类调用，看看怎么调的方法链路
 * 抽象父类定义构造器
 *
 * @since 1.0.0
 */
public abstract class AbstractParent {

    //定义成员变量，存放于堆中，使用过程中不一定会null，当为null时，标识被gc回收了
    //该变量定义成protected，子类也可以访问到，因为可能子类需要修改到，如果定义成private的话，那么需要提供Get/set方法
    protected String code;

    //提供设置code值的方法 该方法子类可重写
    public void setCode(){
        this.code = "123";
    }

    public AbstractParent(String name){

    }

    public void setField(){
        //初次使用该成员变量或被gc回收时，该值为null
        if (StringUtils.isEmpty(code)){
            setCode();
        }
    }

    //子类可以使用
    public void execute(){
        setField();
        System.out.println(code);
    }

    /**
     * 定义一个map 将另一个map 赋值给原map  通过方法 和 = 的方式
     */
    @Test
    public void test2(){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("username","123");
        map = map1;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("当前key：" + entry.getKey());
            System.out.println("当前value：" + entry.getValue());
        }
    }

}
