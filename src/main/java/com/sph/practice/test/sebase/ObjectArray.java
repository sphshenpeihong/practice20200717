package com.sph.practice.test.sebase;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/11/30 16:39
 * Description: 对象数组
 *
 * @since 1.0.0
 */
public class ObjectArray {

    private Test0604 test0604;

    /**
     *
     */
    @Test
    public void test1(){
        Test0604 t1 = new Test0604();
        Test0604 t2 = new Test0604();
        Test0604 t3 = new Test0604();
        //直接new 对象数组对象,初始化的时候直接给对象引用即可。
        Test0604[] instances = new Test0604[]{t1,t2,t3};
        for (Test0604 unit : instances) {
            System.out.println(unit);
        }

    }

}
