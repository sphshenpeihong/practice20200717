package com.sph.practice.test.genericity;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class GenericsClassDemo<T> {
    //t这个成员变量的类型为T,T的类型由外部指定
    private T t;

    //泛型构造方法形参t的类型也为T，T的类型由外部指定
    public GenericsClassDemo(T t) {
        this.t = t;
    }

    //泛型方法getT的返回值类型为T，T的类型由外部指定
    // 当前这个方法并不是泛型方法
    public T getT() {
        return t;
    }
}
