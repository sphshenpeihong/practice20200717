package com.sph.practice.test.markdown.thread;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/10/30 1:36
 * Description: 卖票测试类
 *
 * @since 1.0.0
 */
public class TicketTest {

    /**
     * 开启线程卖票
     * 为什么要开启线程去卖票呢？为什么不能直接调卖票接口呢？
     * 因为可能卖票这个接口执行时间过长，使用线程就是为了异步处理，不会影响主流程的正常执行，故使用线程
     */
    @Test
    public void test1(){
        Ticket ticket = new Ticket();
        //使用匿名内部类的形式去开启线程
        //循环买票
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "小牛").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "小花").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "小红").start();
    }

}
