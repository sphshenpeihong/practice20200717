package com.sph.practice.test.markdown.generic;

import com.sph.practice.test.markdown.annotationAndReflect.UserPO;
import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/11/17 14:11
 * Description:
 *
 * @since 1.0.0
 */
public class StaticClass {

    //直接在类里面定义一个静态变量，并且直接new对象，看看每次使用类.变量名的时候，是否该变量指向的地址会变化？
    //变量放到
    public static UserPO userPO = new UserPO();

    //初始化的时候，判断静态变量是否为空的原因就是因为静态变量是放在方法区，但是引用是放在堆中的，既然放在堆中，那么就是有可能会被回收的，所有需要判断是否为空

    //单例需要自己定义的类去进行单例处理

    /**
     *
     */
    @Test
    public void test(){
        UserPO u = userPO;
    }
}
