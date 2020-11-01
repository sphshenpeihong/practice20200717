package com.sph.practice.test.markdown.threadpool;

/**
 * Created by Shen Peihong on 2020/10/29 21:38
 * Description:线程类
 *
 * @since 1.0.0
 */
public class ThreadTest implements Runnable{
    @Override
    public void run() {
        System.out.println("线程类执行打印语句," + "当前的线程对象的名字叫：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        //创建线程对象，并且去启动线程对象
        ThreadTest thread = new ThreadTest();
        new Thread(thread, "小牛").start();//启动该线程对象，并且给该线程命名
    }
}
