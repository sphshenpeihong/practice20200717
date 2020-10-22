package com.sph.practice.test.markdown.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shen Peihong on 2020/10/20 22:48
 * Description:sdf SimpleDateFormat
 *
 * @since 1.0.0
 */
public class SimpleDateFormatTest {

    /**
     *
     */
    @Test
    public void test(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = sdf.format(now);
        System.out.println(formatTime);
        /*
            2020-10-20 22:50:21
         */
    }

}
