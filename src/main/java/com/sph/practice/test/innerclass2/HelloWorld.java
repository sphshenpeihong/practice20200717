package com.sph.practice.test.innerclass2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class HelloWorld {

    private String xxx = "123";

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(1);
        list.add("123");

    }

    /**
     *
     */
    @Test
    public void test() throws InterruptedException {
        xxx = "456";

        System.out.println("外面：" + this);
        new Thread(() -> {
            System.out.println(this);
            //System.out.println(xxx);
        }).start();
        Thread.sleep(3000);
    }

    private void test1() {

    }

}
