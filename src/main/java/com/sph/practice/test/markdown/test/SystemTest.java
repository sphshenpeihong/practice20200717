package com.sph.practice.test.markdown.test;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/10/20 14:42
 * Description:System类
 *
 *
 * @since 1.0.0
 */
public class SystemTest {

    /**
     * long currentTimeMillis();    long currentTimeMillis = System.currentTimeMillis(); //获得当前时间与1970年1月1号00：00的差值(ms) 称为时间戳    1586099700297
     */
    @Test
    public void test1(){
        long current = System.currentTimeMillis();
        System.out.println(current);//获得当前时间与1970年1月1号00：00的差值(ms) 称为时间戳
        /*
            1603176213798
         */
    }

    /**
     * exit(0);    //结束正在运行的Java程序
     */
    @Test
    public void test2() throws InterruptedException {
        //开启线程 子线程睡眠2秒，主线程结束当前Java程序
        new Thread(() -> {
            System.out.println("子线程打印");
            System.exit(0);//提前结束该方法的执行
        }).start(); //使用代理模式，记得开启线程
        Thread.sleep(1000);
        System.out.println("主线程打印");

        /*
            子线程打印
         */
    }

    /**
     * gc();    //垃圾回收器，手动回收JVM内存中的垃圾。每对某个对象使用gc()方法前，都会执行对应的finalize()方法。对某些对象回收前有骚操作的话，可以在该类中重写finalize()方法。
     */
    @Test
    public void test3(){
        System.gc();
    }

    /**
     *
     */
    @Test
    public void test4(){

    }

    /**
     *
     */
    @Test
    public void test5(){

    }

    /**
     *
     */
    @Test
    public void test6(){

    }

    /**
     *
     */
    @Test
    public void test7(){

    }

    /**
     *
     */
    @Test
    public void test8(){

    }

    /**
     *
     */
    @Test
    public void test9(){

    }



}
