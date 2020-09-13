package com.sph.practice.test.thread;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/9/13 21:01
 * Description:
 *
 * @since 1.0.0
 */
public class TestThread1 {

    public static void main(String[] args) {
        //实例化类的时候，就会将里面的静态变量放到JVM虚拟机的方法区中。这样两个线程使用到了这个变量都是去方法区拿的
        //
        new Thread(new RunThread(),"t1").start();
        new Thread(new RunThread(),"t2").start();
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");
        System.out.println("11");
    }

    /**
     * 单元测试如果识别到执行最后一行完毕后，就直接关闭JVM虚拟机了，相当于关机了，不会再去等线程执行完毕了
     */
    @Test
    public void test(){
        new Thread(new RunThread()).start();
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
    }

}
