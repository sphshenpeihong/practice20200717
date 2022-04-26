package com.sph.practice.test.innerclass;

import org.junit.Test;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class External {

    /**
     *
     */
    @Test
    public void test1() {
        Inner inner = new Inner();
        System.out.println(inner);
    }


    class Inner {

    }

}
