package com.sph.practice.test.markdown.designPattern.proxy.util;

import com.sph.practice.test.markdown.designPattern.proxy.ITeacherDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Shen Peihong on 2020/11/29 16:55
 * Description: 动态代理工具类，提供获取动态代理实例对象(增强对象)
 *
 * @since 1.0.0
 */
public class DynamicProxyUtil<T> {

    //需要依赖目标对象
    private T target;

    public DynamicProxyUtil(T target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        /*
            public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
            arg1：目标对象的类加载器
            arg2：目标对象的实现接口数组
            arg3：调用处理程序，必须实现这个接口，里面的目标对象用invoke方法去调用自身方法，最后return调用的结果呢（可以返回代理对象本身）
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                        接口定义了invoke方法，到时候返回了代理对象后，以后代理对象去调用方法时，都会直接调用这个invoke方法
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理开始了");
                        Object invoke = method.invoke(target, args);
                        System.out.println("动态代理结束了");
                        return invoke;
                    }
                }
        );
    }

}