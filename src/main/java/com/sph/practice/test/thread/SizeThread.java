package com.sph.practice.test.thread;

/**
 * Created by Shen Peihong on 2020/9/29 17:07
 * Description:  当size = 5时，则当前线程处于运行状态
 *
 * @since 1.0.0
 */
public class SizeThread implements Runnable {
    @Override
    public void run() {
        //当前线程监听到list长度为5时，唤醒当前线程
            try {
                AddThread.lock.lock();
                if (AddThread.list.size() != 5) {
                    AddThread.lock.wait();
                }
                System.out.println("SizeThread执行,当前线程名为：" + Thread.currentThread().getName());
                AddThread.lock.notify();//通知add线程继续执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (!AddThread.lock.equals(null)){
                    System.out.println("size解锁 + " + AddThread.lock);
                    AddThread.lock.unlock();
                }
            }
    }
}
