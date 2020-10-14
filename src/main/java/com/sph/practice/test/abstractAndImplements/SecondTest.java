package com.sph.practice.test.abstractAndImplements;

/**
 * Created by Shen Peihong on 2020/9/26 21:15
 */

public class SecondTest extends ParentTest{
    @Override
    public String returnParent() {
        System.out.println("我是二儿子");
        return null;
    }
}
