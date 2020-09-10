package com.sph.practice.test.jdk8.lambda;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/5/17 20:29
 * Description:
 *
 * @since 1.0.0
 */
public class RunnableTest {
    private static int i=0;

    //提供一个开启线程的方法 函数式接口作形参
    public static void runnableTest(Runnable runnable){
        new Thread(runnable).start();
    }

    //调用开启线程方法，由于参数是Runanable接口，所以传递匿名内部类
    @Test
    public void executeTest1(){
        runnableTest(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行");
            }
        });
    }

    //由于参数是函数式接口，所以可以使用lambda表达式
    @Test
    public void executeTest2(){
        //由于知道调用的这个方法的接口类型，所以不需要去new 接口名，直接使用()->{}的形式去实现接口里面的方法即可
        runnableTest(()->{
            System.out.println("这里是接口里面定义方法的方法体");
        });
    }

    //lambda表达式可以简写，省略许多元素 这里省略了方法体的大括号以及方法体中执行语句的分号(前提是方法体的执行语句只有1句时才可以省略分号)
    @Test
    public void executeTest3(){
        //() 括号是方法的括号，具体里面需不需要写参数，还要看定义的函数式接口里面的方法是否有形参
        runnableTest(()-> System.out.println("简写lambda表达式"));
        runnableTest(()->System.out.println("方法体只有一句代码，所以省略语句后面的分号"));
    }

}
