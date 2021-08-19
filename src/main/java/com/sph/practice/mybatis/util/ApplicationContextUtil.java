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

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext paramContext) {
        context = paramContext;
    }

    /**
     * @param name bean注册时命名的name或id
     * @param c    bean的类型
     * @param <T>  泛型
     * @return bean单例对象
     */
    public static <T> T getBean(String name, Class<T> c){
        return context.getBean(name, c);
    }

}
