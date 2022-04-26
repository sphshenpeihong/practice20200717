package com.sph.practice.test.sebase;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sph.practice.test.param.BankVO;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Shen Peihong on 2020/9/16 22:03
 * Description: 测试一些比如map 匿名内部类 以及一些lambda表达式 filter
 *
 * @since 1.0.0
 */
public class JdkBase {

    private String test111 = "test111";




    /**
     * 匿名内部类里面的构造块，可以访问外部变量，但是基本类型只能访问不能修改，但是引用类型既能访问又能修改
     */
    @Test
    public void test(){
        List<String> list = Lists.newArrayList();
        list.add("111");
        list.add("222");
        list.add("333");
        String test = "666";

        Map<String, Object> map = new HashMap<String, Object>() {{
            put("username","123");
            put("password",test);
            put("sex",test111);
            list.add("999");
        }};
        System.out.println(list);
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }

    /**
     * LinkedList
     */
    @Test
    public void test1(){

    }

    /**
     * Map getOrDefault()  当前Map中没有这个key时，返回默认值 不加入原map
     */
    @Test
    public void test6(){
        Map<String, Object> map = Maps.newHashMap();
        map.put("username4", null);
        //使用getOrDefault()方法获取值
        System.out.println(map.get("username"));

        System.out.println(map.getOrDefault("username", "456"));
        //遍历map，看看getOrDefault方法，若原map中没有该key的话，会不会添加到原map中
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("打印key值为：" + entry.getKey());
            System.out.println("打印value值为：" + entry.getValue());
            System.out.println("======");
        }
        //如果直接使用get方法的话，那么获取为null有两种可能，一种是获取的值为null 一种是无此key为null，我们为了防止无此key的时候，需要给个默认值的话就可以使用getOrDefault这个
        //比方有一些字段返回的时候，可能没返回这个字段，那么我们就需要使用该api了。比方调第三方成功会返回token，还有过期时间
    }

    /**
     * computeIfAbsent  这个是当获取key的值为null（2种情况） 会给赋上默认值，会加入原map
     */
    @Test
    public void test7(){

        //一般用于给map加上值，并且防止 两种获取值为null的情况
        Map<String, Object> map = new HashMap<String, Object>(){{
            put("username", "123");
            //put("password", null);
        }};
        Object password = map.computeIfAbsent("password", k -> "123");
        System.out.println(password);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("打印当前Key：" + entry.getKey());
            System.out.println("打印当前Value：" + entry.getValue());
            System.out.println("=========");
        }
    }

    //一般使用这两个api的情况比较
    //先看原map没有这个key的话，那么获取到的值肯定是null值，这种情况会不会有什么影响

    //computeIfAbsent 获取两种为null的情况的话，那么会返回默认值 + 原map增加

    //试试List的contains 还有String的contains
    /**
     *
     */
    @Test
    public void test8(){
        String str = "123456";
        System.out.println(str.contains("2345"));
        System.out.println(str.indexOf("2345"));
    }

    /**
     *
     */
    @Test
    public void test9(){
        Map<String, Object> map = Maps.newHashMap();
        map.put("username","123");
        map.remove("sadasd");
    }

    /**
     * 消费每个list 进行判断，满足条件修改值 看看会不会同步到原来的list
     */
    @Test
    public void test10(){
        List<BankVO> list = new ArrayList<>();
        BankVO bankVO1 = new BankVO("1", "1", "1");
        BankVO bankVO2 = new BankVO("2", "2", "2");
        BankVO bankVO3 = new BankVO("3", "3", "3");
        list.add(bankVO1);
        list.add(bankVO2);
        list.add(bankVO3);
        list.stream().forEach(k -> {
            if ("1".equals(k.getId())){
                k.setPersonName("2323");
            }
        });
        System.out.println(list);


    }


    /**
     * ArrayList
     */
    @Test
    public void test11() throws InterruptedException {
        // 开多个线程，同事操作一个list 防止出现ConcurrentModify
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                // 多线程情况下对ArrayList进行读写，会发生线程安全问题
                list.add(UUID.randomUUID().toString().substring(0, 4));
                System.out.println(list);
            }, "A").start();

        }

        /*for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 4));
            }, "B").start();
            System.out.println(Thread.currentThread().getName());
        }*/

        TimeUnit.SECONDS.sleep(2);
        System.out.println(list);
    }

    volatile List<String> list = new CopyOnWriteArrayList<>();

    /**
     * CopyOnWriteArrayList
     * 同样也会对代码块进行上锁，每次执行添加下一个值时，会先复制一份
     */
    @Test
    public void test12() throws InterruptedException {
        // 开多个线程，同事操作一个list 防止出现ConcurrentModify

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                // 多线程情况下对ArrayList进行读写，会发生线程安全问题
                list.add(UUID.randomUUID().toString().substring(0, 4));
                System.out.println(list);
            }, "A").start();

        }
        TimeUnit.SECONDS.sleep(2);
    }

    // 线程安全，Set
    /**
     *
     */
    @Test
    public void test13(){
        // HashSet的底层就是HashMap
        Set<String> set = new HashSet<>();
        set.add("123");
        new ArrayList<>();
    }

    /**
     * Callable
     */
    @Test
    public void test14() throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().isDaemon());
        CallableTest callable = new CallableTest();
        FutureTask<String> stringFutureTask = new FutureTask<>(callable);
        Thread thread = new Thread(stringFutureTask);
        thread.setDaemon(true);
        thread.start();
        // thread.join(1000);
        Thread.sleep(100);
        System.out.println("我提前先打印1？");
        // String str = stringFutureTask.get();
        System.out.println("我提前先打印2？");
        // System.out.println(str);
        // TimeUnit.SECONDS.sleep(10);
        /*
            我提前先打印1？
            123456
            我提前先打印2？
            Hello,Wolrd!
         */
    }

    /**
     *
     */
    @Test
    public void test15() throws InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().isDaemon());
                Thread.sleep(1000);
                System.out.println("123456");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello,Wolrd!";
        });
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * 死锁
     */
    @Test
    public void test16() throws InterruptedException {
        Lock lock = new ReentrantLock();
        // 两个线程，等同一把锁
        new Thread(() -> {
            lock.lock();
            System.out.println("打印A");
            // 手动抛异常去
            int i = 1 / 0;
            lock.unlock();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            lock.lock();
            System.out.println("打印B");
            lock.unlock();
        }, "B").start();

        TimeUnit.SECONDS.sleep(10);

    }


}

class CallableTest implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().isDaemon());
        Thread.sleep(1000);
        System.out.println("123456");
        Thread.sleep(4000);
        return "Hello,Wolrd!";
    }
}
