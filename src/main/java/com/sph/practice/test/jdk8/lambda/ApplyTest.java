package com.sph.practice.test.jdk8.lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * Created by Shen Peihong on 2020/5/17 23:34
 * Description:
 *
 * @since 1.0.0
 */
public class ApplyTest {

    //Function<T,R>接口，T类型转换成R类型，实现类需要我们自己写
    public static void applyTest(String t,Function<String,Integer> function){
        Integer apply = function.apply(t);
        if (apply instanceof Integer) System.out.println("我是Integer类型");
        else System.out.println("我是其它类型");
    }

    @Test
    public void executeApply(){
        applyTest("111",(String s)->{
            return Integer.parseInt(s);
        });
    }


}
