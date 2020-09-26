package com.sph.practice.test.sebase;

import com.sph.practice.test.bean.CloneParam;
import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/9/24 20:58
 * Description:
 *
 * @since 1.0.0
 */
public class CloneTest {

    /**
     * 调用某实体类的克隆方法，对比与new出来的对象有何区别
     */
    @Test
    public void test(){
        CloneParam cloneParam = new CloneParam();
        cloneParam.setUsername("111");
        CloneParam clone = cloneParam.clone();
        clone.setUsername("222");
        System.out.println(cloneParam == clone);
        System.out.println(cloneParam.getUsername());
        System.out.println(clone.getUsername());

    }

}
