package com.sph.practice;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.sph.practice.mybatis.pojo.QyTestPO;
import com.sph.practice.mybatis.pojo.QyUserPO;
import com.sph.practice.mybatis.util.ApplicationContextUtil;
import com.sph.practice.mybatisplus.config.MybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.RedisTemplate;

// 默认只扫描practice这个目录及以下的注解，但也提供了主动扫描某些目录的属性
@SpringBootApplication()
@MapperScan({"com.sph.practice.mybatis.mapper", "com.sph.practice.mybatisplus.mapper"})
@ImportResource({"classpath:applicationContext.xml"})
@Import({QyTestPO.class, QyUserPO.class, MybatisPlusConfig.class}) //将指定类，加载到Spring容器当中，id的值就是类的全路径
public class PracticeApplication {
    //提供你可以修改

    //自动配置 （默认值）

    public static void main(String[] args) {
        //启动类，返回值是Spring上下文对象（可以说是返回整个IOC容器对象）
        ApplicationContext context = SpringApplication.run(PracticeApplication.class, args);
        ApplicationContextUtil.setContext(context);
        ApplicationContextTest(context);
    }



    // 直接在启动类里面做Spring上下文对象的测试
    private static void ApplicationContextTest(ApplicationContext context){
        // 获得IOC容器中所有的Bean对应的Name值
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            System.out.println(bean);
        }
        //精准获取某个Bean
        MybatisPlusConfig mpc = context.getBean(MybatisPlusConfig.class);
        // 通过Class类型获取对应的Bean的Name值，因为可能存在IOC容器里面一个Class对应好几个id呢
        String[] beanNamesForType = context.getBeanNamesForType(QyTestPO.class);
        System.out.println("===分隔符===");
        for (String beanName : beanNamesForType) {
            System.out.println(beanName);
        }
    }



}
