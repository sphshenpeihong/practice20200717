package com.sph.practice.test.genericity;

import com.sph.practice.test.param.BankVO;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 测试泛型相关使用
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class BankTest {

    /*
        1：Java是动态语言，也即是很多时候在编译时，不确定，很多东西需要在运行时才确定，比如：
        - 泛型，指定的泛型，需要代码运行的时候才确定变量是属于什么类型
     */

    public static void main(String[] args) {
        //测试一下泛型的经典案例
        ArrayList arrayList = new ArrayList();
        arrayList.add("helloWorld");
        arrayList.add("taiziyenezha");
        arrayList.add(88);//由于集合没有做任何限定，任何类型都可以给其中存放
        for (int i = 0; i < arrayList.size(); i++) {
            //需求：打印每个字符串的长度,就要把对象转成String类型
            /*String str = (String) arrayList.get(i);
            System.out.println(str.length());*/
            Object str = arrayList.get(i);
            if (str instanceof String) {
                System.out.println("当前是String类型：" + str);
            } else if (str instanceof Integer) {
                System.out.println("当前是Integer类型" + str);
            }
            System.out.println(str);
        }
    }

    /**
     *
     */
    @Test
    public void test() {
        Bank<String> bank = new Bank<>();
        bank.setObject("111");
        System.out.println(bank);
    }

    /**
     *
     */
    @Test
    public void test1() {
        System.out.println(test12());
    }

    public Bank<?> test11() {
        Bank<Object> objectBank = new Bank<>();
        objectBank.setObject("123");
        return objectBank;
    }

    public Bank test12() {
        Bank objectBank = new Bank();
        objectBank.setObject("123");
        return objectBank;
    }

    public Bank<? extends BankVO> test13() {
        Bank<BankVO> bankVOBank = new Bank<>();
        bankVOBank.setObject(new BankVO());
        return bankVOBank;
    }

    /**
     *
     */
    @Test
    public void test2() {
        ArrayList<?> objects = new ArrayList<>();
        Object o = objects.get(0);

    }


}
