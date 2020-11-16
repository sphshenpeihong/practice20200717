package com.sph.practice.test.markdown.annotationAndReflect;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Shen Peihong on 2020/11/15 23:10
 * Description: 自定义注解
 * 实现功能如下：
 * 使用的范围：变量
 * value：被声明的方法参数，入参无论小写、大写，最终都会变成大写
 *
 * @since 1.0.0
 */
//生命周期
@Retention(RetentionPolicy.RUNTIME)
//作用范围
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
public @interface MyAnnotation {

    @AliasFor("name")
    String value() default "ABC";

    @AliasFor("value")
    String name() default "ABC";

    String seldDefine();

}
