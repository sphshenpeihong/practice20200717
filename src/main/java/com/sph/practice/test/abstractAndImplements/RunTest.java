package com.sph.practice.test.abstractAndImplements;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/9/13 16:15
 * Description:
 *
 * @since 1.0.0
 */
public class RunTest {

    /**
     *
     */
    @Test
    public void test(){
        Animal cat = new Cat();
        System.out.println(cat.parentTest1());
    }

    /**
     *
     */
    @Test
    public void test1(){
        AnimalService animalService = new AnimalServiceImpl();
        System.out.println(animalService.say());
    }

}
