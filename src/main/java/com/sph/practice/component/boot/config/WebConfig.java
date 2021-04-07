package com.sph.practice.component.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Shen Peihong on 2021/3/23
 * Description:
 *
 * @since 1.0.0
 */
@Configuration
public class WebConfig {

    /*
        思想概括：
        1、注册一个bean，Spring底层会去加载你这个bean对象到某个List中，后面会去进行遍历调用方法
        2、方法提供的形参，也都是bean对象了，提供给你调用里面的方法去完成某个功能
     */

    // 注册一个特定类型的bean，到时候Spring会去扫描容器里面是否有该类型的bean
    // 最终会放到一个List<WebMvcConfigurer>类型里边，然后循环调用里面重写的方法
    // 所以我们需要把方法进行重写，特定的功能就会调用特定的方法
    // @Bean  具体就不演示了，反正映射形参的时候，会根据原类型和目标类型，找到合适的Conveter，然后进行类型转换
    public WebMvcConfigurer webMvcConfigurer() {
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
    }

}
