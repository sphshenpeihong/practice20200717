package com.sph.practice.test.sebase.jvm;

import org.junit.Test;

import java.sql.DriverManager;

/**
 * Created by Shen Peihong on 2020/12/27 15:31
 * Description: 获取类加载器的几种方式
 *
 * @since 1.0.0
 */
public class ClassLoaderTest {

    /**
     * 获取类加载器对象
     */
    @Test
    public void test(){
        //1、通过.class对象去获取加载该类的类加载器
        ClassLoader classLoader1 = this.getClass().getClassLoader();
        System.out.println(classLoader1);
        /*
            sun.misc.Launcher$AppClassLoader@18b4aac2
         */

        //2、通过当前线程对象去获取类加载器
        ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader2);
        /*
            sun.misc.Launcher$AppClassLoader@18b4aac2
         */

        //3、通过类提供的静态方法直接获取
        ClassLoader classLoader3 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader3);
        /*
            sun.misc.Launcher$AppClassLoader@18b4aac2
         */
    }

}
