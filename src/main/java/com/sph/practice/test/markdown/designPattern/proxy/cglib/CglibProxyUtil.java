package com.sph.practice.test.markdown.designPattern.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Shen Peihong on 2020/11/29 17:49
 * Description: Cglib代理模式
 *
 * @since 1.0.0
 */
public class CglibProxyUtil<T> implements MethodInterceptor {

    //和jdk代理模式一样，需要依赖目标对象
    private T target;

    public CglibProxyUtil(T target) {
        this.target = target;
    }

    //提供获取代理对象实例
    public T getCglibProxyInstance(){
        //执行四步骤
        //1、创建工具类Enhancer对象
        Enhancer enhancer = new Enhancer();
        //2、设置父类
        enhancer.setSuperclass(target.getClass());
        //3、设置回调函数
        enhancer.setCallback(this);
        //4、创建代理对象
        return (T)enhancer.create();
    }

    /**
     *
     * @param o 代理对象
     * @param method 目标对象的方法
     * @param objects 目标对象的方法入参
     * @param methodProxy 代理方法对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理模式开始！");
        Object invoke = method.invoke(target, objects);
        System.out.println("Cglib代理模式结束");
        return invoke;
    }

}
