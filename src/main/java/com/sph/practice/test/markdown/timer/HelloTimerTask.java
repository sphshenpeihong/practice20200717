package com.sph.practice.test.markdown.timer;

import org.springframework.transaction.annotation.Transactional;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Shen Peihong on 2020/10/22 11:05
 * Description:
 *
 * @since 1.0.0
 */
public class HelloTimerTask extends TimerTask {

    private Timer timer;
    //Thread类才有构造方法给取线程名字

    private static Integer num;

    public HelloTimerTask(Timer timer) {
        this.timer = timer;
    }

    public HelloTimerTask(){}

    @Override
    public void run() {
        System.out.println("定时任务：hello,world");

        //可能发生线程安全的代码放在同步块中  num初始化票=10
        /*synchronized (this){
            System.out.println("当前线程：" + Thread.currentThread().getName() + "定时任务：hello,world" + " ，当前num为：" + num);
            num --;
        }
        if (num <= 0){
            timer.cancel();
        }*/


        //由于cancel会使得当前定时任务执行完毕才结束，故放到最后


    }
}
