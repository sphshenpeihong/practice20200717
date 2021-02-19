package com.sph.practice.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Shen Peihong on 2021/2/10
 * Description:
 *
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class MybatisPlusConfig {

    /**
     * 注册乐观锁拦截器的bean到Spring容器中，MP执行update的方法时，会识别到是哪个实体类，然后拿到反射，判断字段有version字段的话
     * 会向Spring容器拿我们规定好了的乐观锁拦截器先处理一波（可能是用到了该bean里面的方法）
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor getOptimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    public PaginationInterceptor getPaginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }

}
