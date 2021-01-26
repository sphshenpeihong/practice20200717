package com.sph.practice;

import com.sph.practice.mybatis.util.ApplicationContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"com.sph.practice.mybatis.mapper", "com.sph.practice.mybatisplus.mapper"})
public class PracticeApplication {

    public static void main(String[] args)
    {
        //启动类，返回值是Spring上下文对象
        ApplicationContext context = SpringApplication.run(PracticeApplication.class, args);
        ApplicationContextUtil.setContext(context);
    }

}
