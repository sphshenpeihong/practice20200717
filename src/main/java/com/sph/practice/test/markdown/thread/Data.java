package com.sph.practice.test.markdown.thread;

/**
 * Created by Shen Peihong on 2020/10/30 2:06
 * Description: 资源类提供一个Integer类型的数字，然后提供自增和自减方法，实现生产者与消费者模式
 *
 * @since 1.0.0
 */
//数据资源类
//生产者-消费者模式的套路：判断等待 -> 业务代码 -> 通知执行
public class Data {
    //数字
    private Integer num = 0;

    //自增 (防止发生线程安全问题，暂时先使用同步方法的方式)
    //线程安全：因为到时候是开启A和B线程去执行，线程中都是使用循环的方式去调自增和自减方法，可能A线程先抢到了资源，连续执行了2-3次，这种情况就会发生线程安全问题
    //综上，故需要上锁，这样一来，需要释放锁后，其它线程拿到锁了后才可以继续执行
    public synchronized void increment() throws InterruptedException {
        //当值不等于0时，执行等待操作，等待num=0时，被唤醒
        if (num != 0)
            wait();//进行等待操作，会等待被下一次唤醒
        num++;
        System.out.println(Thread.currentThread().getName() + "，已执行+1操作");
        //已实现自增，需要通知其它等待的线程
        notifyAll();
    }

    //自减
    public synchronized void decrement() throws InterruptedException {
        if (num == 0)
            wait();
        num--;
        System.out.println(Thread.currentThread().getName() + "，已执行-1操作");
        notifyAll();
    }
}
