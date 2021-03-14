package com.sph.practice.spring;

import com.sph.practice.component.spring.aopannotation.MathCulculate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by Shen Peihong on 2021/3/2
 * Description:
 *
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationAOPTest {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private MathCulculate mathCulculate;

    /**
     *
     */
    @Test
    public void test1(){
        mathCulculate.culculateDiv(1,1);
    }

}
