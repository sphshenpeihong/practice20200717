package com.sph.practice.component.boot.config;

import com.sph.practice.component.boot.param.ImportClass;
import com.sph.practice.component.boot.pojo.vo.Car;
import com.sph.practice.test.param.DateVO;
import com.sph.practice.test.param.FieldVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Shen Peihong on 2021/2/23
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
@Configuration
@Slf4j
//@EnableConfigurationProperties(Car.class) //如果@ConfigurationProperties所在类没有注解@Component的话，那我们可以按需装配（指向的配置文件类需要的时候再开启允许装配）
@Import({ImportClass.InnerImportClass.class})
public class SpringBootConfig {


    @Bean("dateVO")
    public DateVO dateVO(){
        return new DateVO();
    }

    /*
        当存在dateVO这个bean的时候才会去装配fieldVO这个bean
        注：但是涉及到加载时的先后顺序，这里如果把下面filedVO的代码写在dateVO上面的话，就有问题了。
     */
    @ConditionalOnBean(name = "dateVO")
    @Bean
    public FieldVO fieldVO(){
        return new FieldVO();
    }

}
