package com.sph.practice.test.sebase.base;

import cn.hutool.extra.pinyin.PinyinUtil;
import org.junit.Test;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class PinyinTest {

    /**
     *
     */
    @Test
    public void test1() {
        String str = "23张ss三";
        System.out.println(PinyinUtil.getPinyin(str, ""));
    }

}
