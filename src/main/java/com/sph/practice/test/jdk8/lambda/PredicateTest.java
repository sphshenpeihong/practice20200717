package com.sph.practice.test.jdk8.lambda;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * Created by Shen Peihong on 2020/5/17 22:01
 * Description:Predicate<T> 有时候我们需要对某种类型的数据进行判断，从而得到一个boolean值结果，这时可以使用Predicate<T>接口
 * 一般就是return 条件(符合返回true 不符合返回false)
 * @since 1.0.0
 */
public class PredicateTest {

    public static void predicateTest(Predicate<String> predicate){
        boolean test = predicate.test("helloworld");
        System.out.println("字符串的长度是否大于5呢？答案是："+test);
    }

    @Test
    public void executePredicate(){
        predicateTest( s->s.length() > 5); //接口中方法的实现，前面s的方法的形参，判断s的长度是否大于5
    }

}
