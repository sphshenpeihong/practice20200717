package com.sph.practice.test.inner2;

import org.junit.Test;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
public class OIClassTest {

    /**
     * 测试外、内部类、静态内部类
     */
    @Test
    public void test1() {
        // 内部类对象
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        // 静态内部类对象
        OuterClass.SInnerClass sInnerClass = new OuterClass.SInnerClass();
        OuterClass outerClass = new OuterClass();


    }

}
