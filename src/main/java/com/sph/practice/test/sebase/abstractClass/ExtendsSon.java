package com.sph.practice.test.sebase.abstractClass;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/11/26 14:45
 * Description:
 *
 * @since 1.0.0
 */
public class ExtendsSon extends AbstractParent {

    public ExtendsSon(String name) {
        super(name);
    }

    //重写父类方法
    public void setCode(){
        this.code = "456";
    }

    /**
     *
     */
    @Test
    public void test1(){
        //子类这里调用了父类的方法
        //若链路中调用了父类的方法，但是子类因为重写的话，那么子类优先
        //无论子类是否有@Override声明
        execute();
    }


}
