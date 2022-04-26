package com.sph.practice.test.juc.reentrantlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class ReadWriteLockTest1 {
    public static void main(String[] args) throws InterruptedException {
        MyData myData = new MyData();
        for (int i = 1; i <= 5; i++) {
            final int key = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myData.put(key + "", String.valueOf(key));
                }
            }, "t" + i).start();
        }


        for (int i = 6; i <= 10; i++) {
            final int key = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String s = myData.get((key - 5) + "");
                }
            }, "t" + i).start();
        }
    }
}

class MyData {
    // 可重入的读写锁
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private volatile Map<String, String> map = new HashMap<>();

    public void put(String key, String value) {
        try {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " 正在写入");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入完成");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String get(String key) {
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " 正在读取");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String v = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取完成,读到数据：" + v);
            return v;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

