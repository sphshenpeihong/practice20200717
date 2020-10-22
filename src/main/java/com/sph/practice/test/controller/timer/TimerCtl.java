package com.sph.practice.test.controller.timer;

import com.sph.practice.test.markdown.timer.HelloTimerTask;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Shen Peihong on 2020/10/22 20:10
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/timer")
public class TimerCtl {

    //需求1：延迟3秒后开始执行，输出 "hello,world!"，紧接着每3秒后执行一句hello,world!1 (每次累加1)
    //需求2：定时某个时间节点开始执行，输出 "hello,world!"，紧接着每3秒后执行一句hello,world!1 (每次累加1)
    //操作步骤，先写一个定时任务，然后再写一个开启定时任务的实例

    /**
     * 延迟多少ms后去执行定时任务
     */
    @RequestMapping("/test1.do")
    public void test1(){
        Timer timer = new Timer();
        //arg1：定时任务类(将让定时任务执行的代码块写在run方法中)
        //arg2：延迟多少ms后执行
        timer.schedule(new HelloTimerTask(), 1000);//执行定时任务，延迟1秒
    }

    /**
     *
     */
    @RequestMapping("/test2.do")
    public void test2(){
        Timer timer = new Timer();
        //arg1：定时任务类(将让定时任务执行的代码块写在run方法中)
        //arg2：指定某个时间执行该定时任务
        timer.schedule(new HelloTimerTask(), new Date(System.currentTimeMillis() + 1000));
    }

    /**
     * 创建一个定时任务，用于计数外部变量，累加到10时，停止定时任务
     */
    @RequestMapping("/test3.do")
    public void test3(){
        Timer timer = new Timer();
        timer.schedule(new HelloTimerTask(timer), 1000, 2000);
    }

    /**
     *
     */
    @RequestMapping("/test4.do")
    public void test4(){
        Timer timer = new Timer();
        //arg1：定时任务类(将让定时任务执行的代码块写在run方法中)
        //arg2：延迟多少ms后开始执行定时任务
        //arg3：开始执行后每多久执行一次 （周期单位）
        timer.schedule(new HelloTimerTask(timer), 1000, 2000);
    }

    /**
     *
     */
    @RequestMapping("/test5.do")
    public void test5(){
        Timer timer = new Timer();
        //自定义某个时间
        LocalDateTime localDateTime = LocalDateTime.of(2020, 10, 22, 22, 17, 00);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
        /*
            2020-10-22 22:17:00
         */
        //达到上面的时间时，每2秒打一个helloWorld到控制台
        //arg1：定时任务类(将让定时任务执行的代码块写在run方法中)
        //arg2：自定义某个时间，Date类型
        //arg3：开始执行定时任务后每多久执行一次 （周期单位）
        timer.schedule(new HelloTimerTask(timer), date, 2000);
    }

    /**
     *
     */
    @RequestMapping("/test6.do")
    public void test6(){
        long epochSecond = Instant.now().getEpochSecond(); //获得时间戳精确到秒
        long toEpochMilli = Instant.now().toEpochMilli(); //获得时间戳精确到毫秒 等同 System.currentMillis();
    }

    /**
     *
     */
    @RequestMapping("/test7.do")
    public void test7(){

    }

    /**
     *
     */
    @RequestMapping("/test8.do")
    public void test8(){

    }

    /**
     *
     */
    @RequestMapping("/test9.do")
    public void test9(){

    }

    /**
     *
     */
    @RequestMapping("/test10.do")
    public void test10(){

    }

}
