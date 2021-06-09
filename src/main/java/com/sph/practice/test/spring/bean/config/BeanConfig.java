package com.sph.practice.test.spring.bean.config;

import com.sph.practice.test.spring.bean.BeanService;
import com.sph.practice.test.spring.bean.impl.Bean3ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.1
 */
@Configuration("beanConfig1")
public class BeanConfig {

    // 添加实例bean到Spring容器，可以本身类用@Configuration（一般用作配置类才用这个注解，否则用Component或其它）、Component 也可以配置bean的方式
    @Bean
    public Bean3ServiceImpl beanService3() {
        return new Bean3ServiceImpl();
    }


    public void useBean(String str) {
        System.out.println("入参数字为：" + str + "，打印beanService3 ：" + beanService3());
        // 直接调用@Bean表明的方法，获取到的bean对象，也是同一个单例对象，跟放进Spring容器的bean对象同一个
        // 也即是如果你用@Bean注解去注册bean实例对象的话，那么每当方法被调用，都会优先去Spring直接拿给你
        /*
            入参数字为：0，打印beanService3 ：com.sph.practice.test.spring.bean.impl.Bean3ServiceImpl@a454dfc
            入参数字为：1，打印beanService3 ：com.sph.practice.test.spring.bean.impl.Bean3ServiceImpl@a454dfc
            入参数字为：2，打印beanService3 ：com.sph.practice.test.spring.bean.impl.Bean3ServiceImpl@a454dfc
            入参数字为：3，打印beanService3 ：com.sph.practice.test.spring.bean.impl.Bean3ServiceImpl@a454dfc
            入参数字为：4，打印beanService3 ：com.sph.practice.test.spring.bean.impl.Bean3ServiceImpl@a454dfc
         */
    }

}
