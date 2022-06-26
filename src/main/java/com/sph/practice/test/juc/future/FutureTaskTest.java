package com.sph.practice.test.juc.future;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 练习FutureTask类的使用（异步时，支持携带返回值）
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class FutureTaskTest {

    /**
     *
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        /*
            1、Thread  Runnable
            凡是开启多线程，底层都是需要利用Thread类里面的start方法，去帮助我们开启线程执行
            开启多线程支持extends Thread类，然后去重新run()方法，（虽然执行多线程是调用Thread类的start方法，但是start方法里边的start0()方法
            会去调用run()方法，start0()方法是native方法，C++的，我们看不了源码了）
            当然也可以去实现Runnbale接口，然后重写run方法也行，因为Thread类里边提供了构造方法，去接收Runnbale接口，然后会把该对象复制给自己的target对象
            target对象是Runnbale类型的(Thread类本身也是实现了Runnable接口的)，这里使用的是代理模式，所以，当你如果是是实现Runnable接口，然后采用
            静态代理模式的方式的话，当调用start()方法，底层的start0()方法是会去调用自身的target对象的run()方法的

            2、FutureTask
            但是，但开启子线程去执行后，会发现执行run()方法，执行完run()方法后，没有返回值，我们并不知道子线程执行完了没有，因为run()方法没有返回值的
            而且Runnable接口 除了定义run()方法之外，也没有定义别的方法了，如果又定义可以监控到状态的方法的话，那么我们有了Runnable类型的对象的话
            理论上是可以去获取到对象里边的方法的
            JDK提供了FutureTask类供我们使用，首先FutureTask类实现了RunnableFuture接口，而RunnableFure接口又继承了Runnable接口和Future接口
            RunnableFuture接口去继承Runnable接口是因为Thread类开启多线程只支持Runnable接口，只会去调用Runnable接口的run()方法的。
            所以RunnableFuture接口就不得不去继承Runnable接口，那么继承了Runnable接口的话，肯定当类去实现了RunnableFuture接口的话，肯定是需要去重写
            run()方法的，我们也不得不去重写的话，因为前面说了，Thread类的start()方法底层只会去调用target对象的run()方法的。
            另外，RunnableFuture接口还继承了Callable接口，Callable接口很简单，只定义了一个call()方法，并且有返参，返参的类型是泛型，当前接口不是泛型方法
            泛型的确定而是声明了在接口上方，那么类型的确定最终是落到了实现类，实现类去实现RunnableFuture接口时才确定
            泛型是Future接口指定的，RunnableFuture接口去继承Future接口时，也是需要声明，不然就会报错
            所以，讲到如何使用，我们只需要去写一个类（可以写一个真实的类，也可以去写一个匿名内部类，都可以）去实现Callable接口，然后最终把这个类对象，调用FutureTask类的构造方法传入进去，
            到时候构造方法拿到参数后，就会赋值给自己的属性的。FutureTask定义了Callable接口类型的对象，以及其它一些属性，比如state，所以到时候我们是可以获取state这个属性去获取到当前子线程的状态的
            但是面向对象的思想，是不会直接给你获取到state属性的，而是通过方法的方式去获取到state的属性的，所以也提供了注入isDown()之类的方法，可以让你获取到当前子线程执行的状态
            所以，最终，我们重写的虽然是call()方法，而Thread类最终是去执行run()方法，FutureTask的run()方法底层去调用了我们重写的call()方法
            FutureTask类里边还去定义了outcome属性，这个属性就是result的值，run()方法底层书写了调用call方法，如果call方法执行完毕后，会把返回值赋值给outcome属性
            那么get()方法获取的正是outcome的属性
            get()方法是阻塞的
            所以最终可以获取到子线程执行完毕的返参

         */
        CallableThread call = new CallableThread();
        FutureTask<String> future = new FutureTask<>(call);
        new Thread(future).start();
        System.out.println("打印主线程：" + Thread.currentThread().getName());
        String result = future.get();
        System.out.println(result);
        System.out.println("是否阻塞？" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(201);
    }

    /**
     * Thread.yield()
     */
    @Test
    public void test2() {
        System.out.println("1");
        Thread.yield();
        System.out.println("2");
    }

    static class CallableThread implements Callable<String> {

        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(200);
            System.out.println("打印call：" + Thread.currentThread().getName());
            return "call";
        }
    }

}
