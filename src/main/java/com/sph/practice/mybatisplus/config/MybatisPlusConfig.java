package com.sph.practice.mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.github.pagehelper.Page;
import com.sph.practice.mybatis.pojo.QyTestPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Shen Peihong on 2021/2/10
 * Description:
 *
 * @since 1.0.0
 */
/*
    1、使用@Configuration声明的类，到时候配置类本身也会加入到IOC容器当中
    2、@Bean也会交给Spring容器管理
    3、2.X在@Configuration注解中新加了一个属性，proxyBeanMethods，默认为true，如果声明为true，则配置类对象是一个代理对象来的。
    （从容器里面获取到配置类对象，然后可以直接用对象调用方法，如果上面的属性为true，那么会扫描IOC容器是否有此bean，有的话直接拿容器
    没有的话，才重新new一个。 效率比较低，关键看是否组件依赖时，所依赖的对象是否非要从Spring容器拿(比方DAO依赖DataSource，是否dataSource需要同一个对象)）

 */
@Configuration(proxyBeanMethods = false)
@Slf4j
public class MybatisPlusConfig {

    @Bean
    public QyTestPO getQyTestPO(){
        return new QyTestPO();
    }

    /**
     * 注册乐观锁拦截器的bean到Spring容器中，MP执行update的方法时，会识别到是哪个实体类，然后拿到反射，判断字段有version字段的话
     * 会向Spring容器拿我们规定好了的乐观锁拦截器先处理一波（可能是用到了该bean里面的方法）
     *
     * @return
     */
    @Bean("getOptimisticLockerInterceptor")
    public OptimisticLockerInterceptor getOptimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor getPaginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }

    /**
     * 逻辑删除
     *
     * @return
     */
    @Bean
    public ISqlInjector getSqlInjector(){
        return new LogicSqlInjector();
    }

    /**
     * SQL执行效率插件（可以设置SQL执行多少秒后超时、格式化SQL等）
     *
     * @return
     */
    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor getPerformanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(3000); //ms 设置sql执行的最大时间，如果超过了则不执行
        performanceInterceptor.setFormat(true); //格式化SQL
        return performanceInterceptor;
    }



}
