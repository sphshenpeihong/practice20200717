package com.sph.practice.test.abstractAndImplements;


import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/9/26 21:02
 */

public class SonTest extends ParentTest {

    @Override
    public String returnParent(){
        return "returnSon";
    }

    /**
     * 父类写了一个方法，子类重写父类的方法，那么子类使用this.方法适，若子类有重写方法，则使用子类的，若没有的话则使用父类的方法
     * 若父子类都写了方法，则子类可以使用super调用父类的方法
     */
    @Test
    public void test1(){
        ParentTest test = new SonTest();
        System.out.println(test.returnParent());
        this.print();
        System.out.println("我是沈培泓");
    }

    /*@Override
    void print(){
        System.out.println("printSon");
    }*/

}
