package com.sph.practice.test.jdk8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Shen Peihong on 2020/5/17 21:26
 * Description:Consumer<T>接口则正好与Supplier接口相反，它不是生产一个数据，而是消费一个数据
 *
 * @since 1.0.0
 */
public class ConsumerTest {

    //调用接口中的方法 实现的话由调用该方法的地方去执行实现方法的代码
    public void consumerTest(String name , Consumer<String> consumer){  //这里一般是封装好了的方法，里面会去使用函数式接口对象去调用里面的抽象方法进行操作
        //调用接口里面的方法，返回值是void类型
        consumer.accept(name);
    }

    @Test
    public void executeConsumer(){
        //我们只是实现这个方法而已，书写方法体即可，到时候参数传什么过来，具体由创建该接口对象，然后去执行该方法去传递参数呢
        //只有一行代码的话，省略方法体{} 省略分号;  省略方法形参的括号()  省略方法形参的类型
        consumerTest("赵丽颖",name-> System.out.println(name));//打印传递的参数
        //我们主要是用了这个封装的方法，需要传递lambda表达式，书写实现类
    }

    /*public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User u = new User();
        u.setPassword("123");
        u.setUsername("123");
        list.add(u);
        for (User user : list) {
            System.out.println(user.getUsername());
        }
        for (User user : list) {
            user.setUsername("1");
        }
        for (User user : list) {
            System.out.println(user.getUsername());
        }
    }*/
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        for (String s : list) {

        }
    }

}
