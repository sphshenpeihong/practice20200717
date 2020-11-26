package com.sph.practice.test.sebase.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Shen Peihong on 2020/11/2 1:15
 * Description:FutureTask
 * Thread  Runnable Callable  FutureTask
 *
 * @since 1.0.0
 */
public class ThreadTest {
    //开启线程 静态代理模式只支持Runnable接口的。所以类对象必须是实现了Runnbale接口的，才支持
    //要想支持Callable接口的话，书写一个适配类，然后去实现Runnable接口，然后该适配器类提供一个构造方法参数，允许对象传递
    @Test
    public void test() throws ExecutionException, InterruptedException {
        Callable myThread = new MyThread();
        FutureTask<String> futureTask = new FutureTask<String>(myThread);
        new Thread(futureTask,"A").start();//运行线程
        new Thread(futureTask,"B").start();//运行线程
        String str = futureTask.get(); //线程执行结束后 该实现类对象会有返回值
        System.out.println(str);
    }

}

class MyThread implements Callable<String>{

    //线程执行的代码 使用run()的话，方法执行完毕是没有返回值的，到时候线程运行起来，执行完毕后也是没有返回值的，
    //具体也不知道线程执行完毕后的执行结果是什么情况，如果想知道线程执行过程当中的一些变化的话，
    //可以使用call()方法的形式去书写线程，因为该方法的话是有返回值的，我们可以使用泛型去声明返回值的类型
    //然后在线程执行的方法当中可以去根据想要的变化去书写返回值，到时候我们去获取线程执行完毕后的方法值时
    //就可以根据返回值匹配特定设下的埋点进行匹配了
    //但是有个缺点就是，本来我们线程是异步执行的，但是由于你使用了get方法，导致它不得不去等待线程执行完毕才能获取到return的值
    //所以除非特定情况需要知道线程执行的返回值，否则还是使用run
    //会缓存
    @Override
    public String call() throws Exception {
        System.out.println("call");
        return "String类型";
    }
}
