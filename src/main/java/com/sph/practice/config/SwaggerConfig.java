package com.sph.practice.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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

    public Docket docket(){
        //返回swagger2实例
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
