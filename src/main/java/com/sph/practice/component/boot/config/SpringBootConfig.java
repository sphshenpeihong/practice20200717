package com.sph.practice.component.boot.config;

import com.google.common.collect.Lists;
import com.sph.practice.component.boot.filter2.ThirdFilter;
import com.sph.practice.component.boot.param.*;
import com.sph.practice.component.boot.pojo.vo.Car;
import com.sph.practice.test.param.DateVO;
import com.sph.practice.test.param.FieldVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Filter;
import java.util.concurrent.Executor;

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
@Import({ImportClass.class})
// 激活线程池
@EnableAsync
// 开启定时任务
@EnableScheduling
public class SpringBootConfig {

    // ConditionalProperty和其它注解一样，也是控制组件是否要加载的，下面介绍注解的具体属性
    // prefix：配置文件的前缀
    // name：配置文件的值（组合前缀） 切记不可和value共同使用
    // value：配置文件的值（组合前缀） 切记不可和name共同使用
    // matchIfMissing：当为true时，如果前面声明的配置文件的值没有匹配上的话，也会去注册组件
    // havingValue：假设key确实存在了，但是这里还需要再匹配value值是否匹配上（双重校验key/value），匹配上才会去注册组件
    @Bean("dateVO")
    @ConditionalOnProperty(prefix = "sha1.sha2", value = "sha3", havingValue = "1", matchIfMissing = false)
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

    // 若没有属性，则代表没有当前组件时，则注册组件
    // 当有指定name或value的话，则代表没有指定组件时，才去注册组件
    // 这里可能会存在bean注册的先后问题（可以采用设置bean加载的优先级或顺序啥的）
    @ConditionalOnMissingBean(name = "dateVO")
    @Bean
    public ConditionalOnMissingBeanVO conditionalOnMissingBeanVO(){
        return new ConditionalOnMissingBeanVO();
    }

    // 当我们项目有此类时，才会去注册组件
    @ConditionalOnClass(DispatcherServlet.class)
    @Bean
    public ConditionalOnClassVO conditionalOnClassVO(){
        return new ConditionalOnClassVO();
    }

    // 当我们项目是Servlet编程(非响应式编程)，才注册组件
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    @Bean
    public ConditionalOnWebApplicationVO conditionalOnWebApplicationVO(){
        return new ConditionalOnWebApplicationVO();
    }

    // 当classpath下有此资源文件时，，才会去注册组件
    @ConditionalOnResource(resources = "/local/local.properties")
    @Bean
    public ConditionalOnResourceVO conditionalOnResourceVO(){
        return new ConditionalOnResourceVO();
    }

    /**
     * 线程池bean
     *
     * @return
     */
    @Bean("threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setCorePoolSize(10);
        executorService.setMaxPoolSize(100);
        executorService.setKeepAliveSeconds(3);
        executorService.setQueueCapacity(100);
        return executorService;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new ThirdFilter());
        filter.setName("ThirdFilter");
        filter.setUrlPatterns(Lists.newArrayList("/test/*"));
        return filter;
    }

}
