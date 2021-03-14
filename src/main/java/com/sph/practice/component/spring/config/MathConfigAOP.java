package com.sph.practice.component.spring.config;

import com.sph.practice.component.spring.aopannotation.LogAcspect;
import com.sph.practice.component.spring.aopannotation.MathCulculate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Shen Peihong on 2021/3/2
 * Description:
 *
 * @since 1.0.0
 */
// 开启基于注解的AOP模式
@EnableAspectJAutoProxy
@Configuration
public class MathConfigAOP {

    // 切面组件
    @Bean
    public LogAcspect logAcspect() {
        return new LogAcspect();
    }

    // 业务组件
    @Bean
    public MathCulculate mathCulculate() {
        return new MathCulculate();
    }

}
