package com.sph.practice.component.boot.config;

import com.sph.practice.component.boot.intercetor.UrlIntercetor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Shen Peihong on 2021/3/23
 * Description: 配置类(该类也会被注册成Bean)
 * Spring提供了WebMvcConfigurer接口，里面提供了大量的方法，可以支持我们去做各种操作
 * 比如：添加拦截器、参数解析器、类型转换器、跨域处理器、
 *
 *
 * @since 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加一个拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        // 添加拦截器的话，这个拦截器对象如果是Spring容器中的实例bean对象的话，也可以不用new，可以将该对象，放本类去@Bean声明注册
        registry.addInterceptor(new UrlIntercetor())
                // 对哪些请求进行拦截器处理（如果不配置指定，那么默认是所有请求都会进行拦截器处理，相当于配置了/**）
                .addPathPatterns("/hello1/**")
                // 哪些请求不进行拦截器处理
                .excludePathPatterns("/completableFuture/**");
    }

}

// 配置一个bean
// 1、实现某个接口或继承某个类，+ @Configuration
// 2、@Bean + @Configuration
    /*
        思想概括：
        1、注册一个bean，Spring底层会去加载你这个bean对象到某个List中，后面会去进行遍历调用方法
        2、方法提供的形参，也都是bean对象了，提供给你调用里面的方法去完成某个功能
     */

// 注册一个特定类型的bean，到时候Spring会去扫描容器里面是否有该类型的bean
// 最终会放到一个List<WebMvcConfigurer>类型里边，然后循环调用里面重写的方法
// 所以我们需要把方法进行重写，特定的功能就会调用特定的方法
// @Bean  具体就不演示了，反正映射形参的时候，会根据原类型和目标类型，找到合适的Conveter，然后进行类型转换
    /*public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer(){
            // 形参是肯定不会是null的，一般可以直接看看该对象里面有什么方法
            @Override
            public void addFormatters(FormatterRegistry registry) {
                // registry对象里面提供了add方法，执行该add方法，会把Converter对象给添加到某个List中

                registry.addConverter(new Converter<String, Object>(){

                    @Override
                    public Object convert(String source) {
                        return null;
                    }
                });
            }
        };
    }*/