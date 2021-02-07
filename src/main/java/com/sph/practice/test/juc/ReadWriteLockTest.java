package com.sph.practice.test.juc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Shen Peihong on 2021/2/8 0:19
 * Description: JUC---读写锁
 *
 * @since 1.0.0
 */
public class ReadWriteLockTest {

    /**
     * 读写锁 ReentranReadWriteLock
     *
     * @throws InterruptedException
     */
    @Test
    public void test1() throws InterruptedException {
        MyCache cache = new MyCache();

        //开启5个线程存值，5个线程进行取值
        for (int i = 0; i < 20; i++) {
            final String temp = String.valueOf(i);
            new Thread(() -> {
                cache.put(temp, temp);
            }, temp).start();
        }

        for (int i = 0; i < 20; i++) {
            final String temp = String.valueOf(i);
            new Thread(() -> {
                cache.get(temp);
            }, temp).start();
        }

        TimeUnit.SECONDS.sleep(1);

    }

}

/**
 * 自定义缓存
 */
class MyCache {
    private volatile Map<String, Object> cacheMap = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object Value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始存值");
            cacheMap.put(key, Value);
            System.out.println(Thread.currentThread().getName() + "存值OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始取值");
            cacheMap.get(key);
            System.out.println(Thread.currentThread().getName() + "取值OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}