package com.sph.practice.test.thread;

/**
 * Created by Shen Peihong on 2020/9/13 20:19
 * Description:
 *
 * @since 1.0.0
 */
public class RunThread implements Runnable{
    //线程里面的成员变量和run方法里面的局部变量，都是当前类所定义的，
    private static int count = 100;
    //如果加锁的话，那么
    @Override
    public void run() {
        try {
            while (true){
                if (count > 0){
                    System.out.println("线程名字："+ Thread.currentThread().getName() +"当前count值：" + count);//两个线程可能几乎同时拿了count，都拿了100，然后几乎同时执行了count--。
                    Thread.sleep(500);
                    count--;
                }else{
                    break;
                }
            }
            System.out.println("执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
