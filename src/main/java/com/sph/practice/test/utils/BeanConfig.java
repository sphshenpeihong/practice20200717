package com.sph.practice.test.utils;

import com.sph.practice.test.bean.BeanVO;
import com.sph.practice.test.param.BankVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Shen Peihong on 2020/12/19 22:36
 * Description: bean配置类
 *
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class BeanConfig {

    //获取一下刚配置的bean
    @Bean
    public BeanVO beanVO(BankVO bankVO){
        System.out.println("BeanConfig配置类：" + bankVO);
        return new BeanVO();
    }

}
