package com.sph.practice.component.boot.pojo.po;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Shen Peihong on 2021/2/23
 * Description: Car类的值是直接读取配置文件的值(也即是属性进行DI注入)。然后这个类也是交给Spring容器管理
 * 也就是说，类里面的属性想注入值的话，并不一定要一个一个属性使用@Value进行DI注入
 * 也可以整个类去映射配置文件进行映射读取。
 *
 * @since 1.0.0
 */
//@Component
// 读取配置文件类去读取配置文件的话，必须要保证这个类同时也是交给Spring容器管理的，这样才能拿到配置文件的值
@ConfigurationProperties(prefix = "my-car")
@Data
public class Car {
    private String carName;
    private Integer carPrice;
}
