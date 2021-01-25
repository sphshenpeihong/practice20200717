package com.sph.practice.test.sebase.enm;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2021/1/23
 * Description:
 *
 * @since 1.0.0
 */
public class EnmDefinedTest {

    /**
     * 试试引用枚举常量
     */
    @Test
    public void test(){
        String s = EnmDefined.SPRING.toString();
        System.out.println(s);
    }

}
