package com.sph.practice.test.sebase.current;

import org.junit.Test;

/**
 * Created by Shen Peihong on 2020/12/11 23:23
 * Description:
 *
 * @since 1.0.0
 */
public class Client {

    /**
     *
     */
    @Test
    public void test(){
        CurrentClass currentClass = new CurrentClass();
        System.out.println(currentClass);
        CurrentClass currentClass1 = currentClass.query("1").query1("2").query3("3");
        System.out.println(currentClass1);
        System.out.println(currentClass.str);
    }

}
