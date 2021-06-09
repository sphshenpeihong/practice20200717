package com.sph.practice.mybatis.util;

import org.springframework.context.ApplicationContext;

/**
 * Created by Shen Peihong on 2020/12/23 16:26
 * Description: Spring上下文对象工具类
 *
 * @since 1.0.0
 */
public class ApplicationContextUtil {
    //定义Spring上下文对象，启动时，会返回Spring上下文对象回来，所以到时候通过依赖注入进来
    //变量定义成static类型的，类加载识别到static时，先赋零值
    private static ApplicationContext context;

    public ApplicationContextUtil(){}

    //支持构造方法注入
    public ApplicationContextUtil(ApplicationContext context) {
        this.context = context;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    //也支持set方法注入
    public static void setContext(ApplicationContext paramContext) {
        context = paramContext;
    }

    //提供一个getBean方法 两个参数，一个是想获取的反射类型，一个是注册时的id或name
    public static <T> T getBean(String name, Class<T> c){
        return context.getBean(name, c);
    }

}
