package com.sph.practice.test.sebase;

import com.sph.practice.test.bean.TimeEnm;
import org.junit.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shen Peihong on 2020/9/24 22:04
 * Description:
 *
 * @since 1.0.0
 */
public class EnumTest {

    /**
     * 使用枚举变量
     */
    @Test
    public void test() throws InterruptedException {
        System.out.println(TimeEnm.TIME1.getTime());
        System.out.println(TimeEnm.paramMap.get("username"));
    }

    /**
     *
     */
    @Test
    public void test1(){

    }

    /**
     *
     */
    @Test
    public void test2(){
        System.out.println(TimeEnm.TIME1.getTest1());
    }

    public static void main(String[] args) {
        //可以调用枚举类的values()方法获取枚举类对象数组，得到的是枚举类的每个实例化对象
        TimeEnm[] values = TimeEnm.values();
        for (TimeEnm value : values) {
            System.out.println(value.getTime());
        }
    }
}
