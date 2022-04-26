package com.sph.practice.test.jdk8.lambda;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * Created by Shen Peihong on 2020/5/17 20:56
 * Description:Suuplier<T>生产接口，仅包含一个无参的方法：T get()。用来获取一个泛型参数指定类型的对象数据
 * supplier<T>接口被称之为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会生产什么类型的数据
 * @since 1.0.0
 */
public class SupplierTest {

    //生产接口 提供String类型数据
    public static String supplierTest(Supplier<String> supplier){
        //调用接口里面的get方法，接口也是.class类型，实例对象可以调用里面的变量或方法
        //而是接口里面的方法的实现具体由调用方去处理
        return supplier.get();
    }

    //调用生产接口Supplier<T>
    @Test
    public void executeSupplier(){
        //由于函数式接口里面定义的方法有返回值，所以实现方法的时候也需要return
        //由于只有一行代码，所以花括号、分号、return 都可以省略不写
        String response = supplierTest(() -> "OK"); //一般实现方法的方法体中不是输出语句的话，那么可以确定是省略了return的
        //这里调用完是有返回值类型的
        System.out.println(response);
        /*
            OK
         */
    }

    //定义Supplier是Integer类型
    public Integer supplierInteger(Supplier<Integer> supplier){
        return supplier.get();
    }

    //调用含有Supplier<T>函数式接口的方法
    @Test
    public void executeSupplierInteger() {
        Integer min = 9;
        Integer max = 10;
        //返回两个数的最大值
        Integer maxNum = supplierInteger(() -> max > min ? max : min);//省略了{} ;  return
        System.out.println("两个数的最大值为：" + maxNum);
        /*
            两个数的最大值为：10
         */
    }


}
