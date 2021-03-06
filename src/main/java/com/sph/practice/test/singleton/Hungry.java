package com.sph.practice.test.singleton;

/**
 * Created by Shen Peihong on 2020/10/17 23:54
 * 单例模式
 * 1、饿汉式创建实例对象
 * 缺点：多线程情况下，每次使用到类去访问成员变量时，都会在常量池new出一份，很浪费常量池的内存大小。
 */

public class Hungry {

    //类的成员变量无论在哪个类都要定义成私有的，即使单独访问成员变量，可以提供get方法，封装的思想，保证安全
    //单例模式---饿汉式创建单例对象，无论三七二十一，但每次用类去访问到成员变量时，都会将成员变量创建一份，放到常量池的空间中
    //误区：首先static变量方法区肯定是只有一份了，那么这里用new创建了对象，那么创建完后自然会在堆创建分配内存空间存放，那么理所当然
    //该变量指向堆里面的某个内存空间，一直死死指向，但是如果你有理无理使用的时候又重新new对象，那么就会改变指向
    //即使使用了懒汉式双重校验锁初始化了对象后，也不是说方法区这个变量就一直指向它，因为这个对象可能在堆中使用GC回收机制进行回收了。
    //那么下一次有个线程去获取该变量时，判断该变量为null的话，那么自然就会重新new一遍了。
    private static Hungry HUNGRY = new Hungry();

    //构造器私有化，不对外提供构造器，只提供公用的创建实例的方法
    private Hungry(){}

    //提供获取HUNGRY方法
    public static Hungry getInstance(){
        return HUNGRY;
    }

}
