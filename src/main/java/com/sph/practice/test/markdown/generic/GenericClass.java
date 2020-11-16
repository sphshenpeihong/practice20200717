package com.sph.practice.test.markdown.generic;

/**
 * Created by Shen Peihong on 2020/11/16 20:13
 * Description: 泛型类
 *
 * @since 1.0.0
 */
public class GenericClass<T> {

    //定义泛型变量
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
