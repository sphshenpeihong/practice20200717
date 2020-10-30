package com.sph.practice.test.markdown.thread;

/**
 * Created by Shen Peihong on 2020/10/30 1:32
 * Description: 车票资源类，并且定义相关操作车票的方法
 *
 * @since 1.0.0
 */
//车票资源类
public class Ticket {

    private Integer ticket = 100;

    //封装卖票方法，执行卖票，每调一次，则卖票一张
    public void saleTicket(){
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + "，买票成功," + "当前剩余票为" + --ticket);
        }
    }


}
