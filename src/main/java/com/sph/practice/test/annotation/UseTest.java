package com.sph.practice.test.annotation;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2021/1/30
 * Description:
 *
 * @since 1.0.0
 */
public class UseTest {

    /**
     *
     */
    @Test
    public void test1(){
        // 这里我们就可以利用反射去拿到注解了。但是我们想要的效果是 使用的时候，就帮我们处理好了的呢
        // 我们有这样的想法的话，一定是得有一个时机去利用反射，去帮你set值的。不然没那么智能的额。。。
        // 除非在类加载的时候，就去处理了，类加载的时候，但是如果是时间的话，也不可能是写死的额。
        // 这里我们简单调用一个方法的时候，把这个方法当作底层方法
        // 注解结合反射的话，我们当作已经了解了，反正注解的话，是自己自定义的话，如果没有反射去获取你的注解的话
        // 那注解加了和没加没什么区别
        // 但是我们在使用别人写好了的注解的话，那我们就需要关注于注解、注解里面的属性，以及有什么作用，有什么用
        // 有额外之力的话 可以考虑一下注解的反射时机
        UseBean useBean = new UseBean();
        System.out.println(useBean);

    }

}
