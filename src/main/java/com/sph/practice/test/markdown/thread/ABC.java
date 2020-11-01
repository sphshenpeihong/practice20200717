package com.sph.practice.test.markdown.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Shen Peihong on 2020/10/30 2:54
 * Description: 打印A、B、C
 *
 * @since 1.0.0
 */
public class ABC {
    /*
        1、A打印完后，通知B打印
        2、B打印完后，通知C打印
        3、C打印完后，通知A打印
        //......依次循环数次
        方法思路：使用锁结合condition监视器对象(等待，准确通知的方式)

     */

    //创建可重入锁对象
    private Lock lock = new ReentrantLock();
    //创建condition监视器对象 (监视器对象里面提供了等待方法、通知方法(可准确通知某个监视器))
    //每个打印方法配备一个监视器对象，提供是否等待或被通知等操作
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Integer num = 1; //标志位 1A 2B 3C


    //封装打印A方法
    public void printA(){
        //使用Lock 结合Condition的等待、通知(可以准确唤醒某个condition监视器对象)
        try {
            lock.lock();
            //需要有个标志位，判断是否进入等待
            //使用while，而不使用if的原因是防止虚假唤醒：因为if只会执行一次，一旦线程执行完if后，就会卡在wait()方法，不会再判断条件了，所以需要使用while，循环判断
            while (num != 1){
                condition1.await();
            }
            System.out.println("打印AAA");
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //封装打印B方法
    public void printB(){
        //使用Lock 结合Condition的等待、通知(可以准确唤醒某个condition监视器对象)
        try {
            lock.lock();
            //需要有个标志位，判断是否进入等待
            //使用while，而不使用if的原因是防止虚假唤醒：因为if只会执行一次，一旦线程执行完if后，就会卡在wait()方法，不会再判断条件了，所以需要使用while，循环判断
            while (num != 2){
                condition2.await();
            }
            System.out.println("打印BBB");
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //封装打印C方法
    public void printC(){
        //使用Lock 结合Condition的等待、通知(可以准确唤醒某个condition监视器对象)
        try {
            lock.lock();
            //需要有个标志位，判断是否进入等待
            //使用while，而不使用if的原因是防止虚假唤醒：因为if只会执行一次，一旦线程执行完if后，就会卡在wait()方法，不会再判断条件了，所以需要使用while，循环判断
            while (num != 3){
                condition3.await();
            }
            System.out.println("打印CCC");
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



}
