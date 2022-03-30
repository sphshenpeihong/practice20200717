package com.sph.practice.test.sebase;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 测试一些简单场景，加深对基础的深入理解
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class Test20220323 {

    // 值传递与地址传递

    /**
     *
     */
    @Test
    public void test1() {
        int i = 1;
        this.add(i);
        System.out.println(i);
    }

    /**
     *
     */
    @Test
    public void test2() {
        String str = "123";
        str = "456";
        String str1 = str;
        str1 = "666";
        System.out.println(str);
    }

    private void changeObject(final Test0604 t) {}

    private void addStr(String str) {
        str = "789";
    }

    /**
     *
     */
    @Test
    public void test3() {
        Long i = 3222L;
        System.out.println(i.hashCode());
        testInteger(i);
        System.out.println(i.hashCode());
    }

    /**
     *
     */
    @Test
    public void test4() {
        ArrayList<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        String[] strings = {"1dd", "322", "3434", "12212"};
        String[] objects = list.toArray(strings);
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
            System.out.println("haha");
            System.out.println(strings[i]);
        }

    }

    private void testInteger(Long i) {
        System.out.println(i.hashCode());
        i += 1;
        System.out.println(i.hashCode());
    }


    private void add(int i) {
        i += 1;
    }

}
