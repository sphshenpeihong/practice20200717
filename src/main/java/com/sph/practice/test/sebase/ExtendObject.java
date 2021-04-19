package com.sph.practice.test.sebase;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Shen Peihong on 2021/2/22
 * Description:
 *
 * @since 1.0.0
 */
public class ExtendObject extends Object{



    /**
     *
     */
    @Test
    public void test1() throws Exception {
        int[] ints = new int[]{22,23};
        System.out.println(URLEncoder.encode("&", "utf-8"));
        try {
            int i = 1 / 0;
        }  finally {
            System.out.println("1");
        }
        System.out.println("2");
    }

    @Override
    public boolean equals(Object obj) {
        return "1".equals(obj);
    }
}
