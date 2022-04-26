package com.sph.practice.test.markdown.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 反射
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class ReflectTest1 {

    /**
     *
     */
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        // 创建实体类对象，对实体类的属性进行赋值
        ReflectPO reflectPO = new ReflectPO();
        reflectPO.username = "123";
        // 利用反射（获取该类的private变量，set方法会提供要进行操作的具体对象以及赋值），对实体类的private变量进行赋值
        Class<ReflectPO> clazz = ReflectPO.class;
        Field id = clazz.getDeclaredField("id");
        id.setAccessible(true);
        id.set(reflectPO, 232312);
        System.out.println(reflectPO);
    }

}
