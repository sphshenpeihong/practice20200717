package com.sph.practice.test.markdown.timer;

import org.junit.Test;

import java.util.Timer;

/**
 * Created by Shen Peihong on 2020/10/22 11:02
 * Description:Timer定时类， TimerTask定时任务类
 *
 * @since 1.0.0
 */
public class TimerAndTimerTask {
    //需求1：延迟3秒后开始执行，输出 "hello,world!"，紧接着每3秒后执行一句hello,world!1 (每次累加1)
    //需求2：定时某个时间节点开始执行，输出 "hello,world!"，紧接着每3秒后执行一句hello,world!1 (每次累加1)
    //操作步骤，先写一个定时任务，然后再写一个开启定时任务的实例

    /**
     * 延迟一秒后去执行该定时任务
     */
    @Test
    public void test(){
        Timer timer = new Timer();
        timer.schedule(new HelloTimerTask(), 1000);//执行定时任务，延迟1秒
    }

}
