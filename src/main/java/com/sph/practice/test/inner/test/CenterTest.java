package com.sph.practice.test.inner.test;

import org.junit.Test;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
public class CenterTest {


    /**
     * 内部类和惊天内部类
     */
    @Test
    public void testClass() {

        // 内部类或内部静态类，本质也是属于CenterClass的对象
        CenterClass centerClass = new CenterClass();
        CenterClass.InnerClass innerClass = centerClass.new InnerClass();
        new CenterClass().new InnerClass();
        CenterClass.staticInnerClass staticInnerClass = new CenterClass.staticInnerClass();
        CenterClass centerClass1 = new CenterClass();
        staticInnerClass.test();
        CenterClass.staticInnerClass.staticTest();
    }

    /**
     * 内部接口和静态内部接口（默认接口不加）
     */
    @Test
    public void testInterface() {
        CenterClass.InnerInterface innerInterfaceImpl1 = new CenterClass().new InnerInterfaceImpl1();
    }


}
