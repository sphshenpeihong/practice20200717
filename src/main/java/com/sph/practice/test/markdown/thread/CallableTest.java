package com.sph.practice.test.markdown.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shen Peihong on 2020/11/2 20:11
 * Description: callable接口的使用
 *
 * @since 1.0.0
 */
public class CallableTest {
    /**
     * public FutureTask(Callable<V> callable);
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        //Thread的构造参数支持Runnbale接口，但是不支持Callable接口，所以需要找一些类实现了Runnbale接口，并且该类的构造方法或方法支持Callable接口的，
        //所以选用了FutureTask类(实现Callable接口，提供构造方法支持Callable类型
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask).start();
        new Thread(() -> {
            try {
                //等待返回太久了，使用异步处理
                //获取线程call()方法的返回值
                System.out.println(futureTask.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("上面使用异步处理，这里主线程就会先执行了");
        TimeUnit.SECONDS.sleep(5);
    }

}


class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {

        TimeUnit.SECONDS.sleep(3);
        return "successful";
    }
}