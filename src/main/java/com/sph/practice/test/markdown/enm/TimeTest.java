package com.sph.practice.test.markdown.enm;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen Peihong on 2020/10/21 20:11
 * Description:
 *
 * @since 1.0.0
 */
public class TimeTest {

    /**
     *
     */
    @Test
    public void test(){
        //获取枚举的对象
        System.out.println(TimeEnm.Time1.getTime());
        System.out.println(TimeEnm.str);
        for (TimeEnm value : TimeEnm.values()) {
            System.out.println(value.getTime());
        }
        List<Object> list = Lists.newArrayList();

    }

}
