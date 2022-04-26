package com.sph.practice.test.innerclass;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class Demo {

    int count = 10;

    public static void main(String[] args) {
        System.out.println(Demo.class.getCanonicalName());

    }

    /**
     *
     */
    @Test
    public void test() throws InterruptedException {
        run();
        Thread.sleep(1000);
    }

    public void run() {

//        ArrayList<String> list = Lists.newArrayList();
//        this.test(list);

        //ArrayList<String> list = Lists.newArrayList();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        System.out.println(runnable.getClass().getCanonicalName());
        new Thread(runnable).start();
    }

    private void test(ArrayList<String> list) {
        list = new ArrayList<>();
    }


}


