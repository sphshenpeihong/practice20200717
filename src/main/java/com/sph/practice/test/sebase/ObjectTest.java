package com.sph.practice.test.sebase;

import com.sph.practice.test.bean.User;
import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/9/29 16:57
 * Description: 测试一下Object的底层方法
 *
 * @since 1.0.0
 */
public class ObjectTest {

    /**
     *
     */
    @Test
    public void test() throws CloneNotSupportedException {
        Object o2 = new Object();
        Object o = new Object();
        Object o1 = o;
        System.out.println(o1.hashCode());
        System.out.println(o.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(o.equals(o1));
    }

}
