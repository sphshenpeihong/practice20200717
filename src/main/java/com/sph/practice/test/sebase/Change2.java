package com.sph.practice.test.sebase;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shen Peihong on 2020/12/26 16:06
 * Description:
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/change2")
public class Change2 {

    @RequestMapping("/test1.do")
    public void test1(){
        Change1 change1 = new Change1();
        System.out.println(change1.username);
    }

    /**
     *
     */
    @Test
    public void test(){

    }

}
