package com.sph.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by Shen Peihong on 2020/10/14 21:05
 * Description:由于Spring没有集成Swagger2，所以需要自己手动地书写配置类，将Swagger2加入到Spring容器中
 * 如果Spring有集成的话，那么直接在yml文件里面就可以找到对应的相关key值了。(有集成的话，那么Spring会有默认值，修改key值只是根据我们自己的需要去更改)
 *
 * @since 1.0.0
 */
//凡是需要将某个bean配置到Spring容器中的，都需要使用@Configuration + @Bean
@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {
    //目前什么bean都没配，那么由于我们引入了Swagger2的jar包，jar包里面肯定会配置了默认值。我们这里主要还是做开启Swagger2 + 将Swagger2加入到Spring容器当中
    //swagger2默认的访问路径 /swagger-ui.html

    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test", "local");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        //调用该方法可以将方法参数配置的值和application.properties或application.yml配置的 spring.profiles.active的值进行比对，如果匹配得上则为true，反之则false
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);

        //返回全新封装的swagger2实例
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //enable是否启动Swagger，如果为false，则Swagger不能在浏览器中访问
                .enable(flag)
                .select()
                //对指定包进行注解(GetMapping等)扫描  默认是any()
                .apis(RequestHandlerSelectors.basePackage("com.sph.practice"))
                .build();
    }

    //配置Swagger信息 apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("沈培泓", "https:www.baidu.com", "939247689@qq.com");
        return new ApiInfo(
                "沈培泓的SwaggerAPI文档",
                "给爷冲冲冲",
                "v1.0",
                "https://www.taobao.com",
                contact,
                "Apache 2.0",
                "https://www.jingdong.com",
                new ArrayList<>()
        );
    }
}
