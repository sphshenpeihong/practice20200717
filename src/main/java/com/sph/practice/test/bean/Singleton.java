package com.sph.practice.test.bean;

/**
 * Created by Shen Peihong on 2020/10/8 20:19
 * Description:使用单例模式-- 懒汉式双重校验锁
 *
 * @since 1.0.0
 */
public class Singleton {
    private static Singleton instance = null;

    //不对外提供new对象的功能
    private Singleton() {
    }

    //对外提供获取单例对象的方法，使用懒汉式双重校验锁
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance =  new Singleton();
                }
            }
        }
        return instance;
    }
}
